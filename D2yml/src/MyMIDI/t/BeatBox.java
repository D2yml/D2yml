package MyMIDI.t;

import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
 
public class BeatBox {
	
	//窗口对象(相当于<body>标签)
    JPanel mainPanel;
    
    //复选框
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    
    //音轨
    Track track;
    
    //窗口对象(相当于<html>标签)
    JFrame theFrame;
    
    //乐器库
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", 
       "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap", 
       "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", 
       "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", 
       "Open Hi Conga"};
    
    //乐器对应音色代码
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
     
 
    public static void main (String[] args) {
        new BeatBox().buildGUI();
    	int i = (2 & 0x0F) ;
    	System.out.println(i);
    	System.out.println(0x0F);
    	System.out.println(0xF0);
    }
   
    public void buildGUI() {
    	//创建一个带有标题的空的窗口
        theFrame = new JFrame("Cyber BeatBox");
        //设置点击X号时操作,这里同时推出JVM
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //构造一个组件之间没有间距的默认布局(CENTER)
        BorderLayout layout = new BorderLayout();
        //创建指定布局管理器的面板
        JPanel background = new JPanel(layout);
        //添加默认空边框
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //初始化复选框
        checkboxList = new ArrayList<JCheckBox>();
        //从上到下排列的按钮
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        //创建一个Statr按钮并添加监听事件
        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);         
           
        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);
 
        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);
 
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);
 
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
           nameBox.add(new Label(instrumentNames[i]));
        }
         
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
 
        theFrame.getContentPane().add(background);
           
        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);
 
        for (int i = 0; i < 256; i++) {                    
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);            
        } // end loop
 
        setUpMidi();
 
        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    } // close method
 
 
    public void setUpMidi() {
      try {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequence = new Sequence(Sequence.PPQ,4);
        track = sequence.createTrack();
        sequencer.setTempoInBPM(120);
         
      } catch(Exception e) {e.printStackTrace();}
    } // close method
 
    public void buildTrackAndStart() {
      int[] trackList = null;
      //删除之前的轨道对象
      sequence.deleteTrack(track);
      //创建一条新的轨道
      track = sequence.createTrack();
        for (int i = 0; i < 16; i++) {
          trackList = new int[16];
          //拿到每个音色
          int key = instruments[i];   
          //将被勾选的音色添加到轨道中
          for (int j = 0; j < 16; j++ ) {         
              JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
              if ( jc.isSelected()) {
                 trackList[j] = key;
              } else {
                 trackList[j] = 0;
              }                    
           } // close inner loop
          
           makeTracks(trackList);
           track.add(makeEvent(176,1,127,0,16));  
       } // close outer
       //设置乐器
//       track.add(makeEvent(192,10,1,0,15));      
       try {
           sequencer.setSequence(sequence); 
           sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);                   
           sequencer.start();
           sequencer.setTempoInBPM(120);
       } catch(Exception e) {e.printStackTrace();}
    } // close buildTrackAndStart method
             
            
    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
        	//绑定轨道并开始播放
            buildTrackAndStart();
        }
    } // close inner class
 
    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    } // close inner class
 
    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
          float tempoFactor = sequencer.getTempoFactor(); 
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
     } // close inner class
 
     public class MyDownTempoListener implements ActionListener {
         public void actionPerformed(ActionEvent a) {
          float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    } // close inner class
 
    public void makeTracks(int[] list) {        
        
       for (int i = 0; i < 16; i++) {
          int key = list[i];
 
          if (key != 0) {
             track.add(makeEvent(144,9,key, 100, i));
             track.add(makeEvent(128,9,key, 100, i+1));
          }
       }
    }
    
    /**
     * 创建Midi事件
     * @param comd		Midi命令代码
     * @param chan		指定音轨
     * @param one		执行的音色代码
     * @param two		音量
     * @param tick		执行的时间
     * @return
     */
    public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
 
        } catch(Exception e) {e.printStackTrace(); }
        return event;
    }
 
} // close class