package MyMIDI;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice.Info;

import com.sun.prism.impl.Disposer.Target;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

/**
 * 
 * @author D2yml
 * @date 2018年12月
 */
public class HelloMIDI {
	//文件对象
	private static Sequence sequence1;
	//文件播放器
	private static Sequencer sequencer1;
	//音轨
	private static Track tracks;
	//Midi事件
	private static MidiEvent event;
	//Midi信息
	private static MidiMessage message;
	//Midi信息加载类
	private static MyReceiver receiver = new MyReceiver();

	public static void main(String[] args) {
		MidiGo( 5);	
	}
	
	/**
	 * 速度监控
	 * 
	 * @param sequencer		序列化音序器
	 * @param solo			是否solo
	 * @param track			指定某条音轨
	 * @param bpm			每分钟四分音符出现的次数
	 */
	public static void getTick(final Sequencer sequencer,boolean solo,int track,Float bpm) {
		sequencer.setTrackSolo(track, solo);
		sequencer.setTempoInBPM(bpm);
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("当前共:" + sequencer.getTickLength() + "小节");
				while (sequencer.isRunning()) {
					System.out.println("当前速度每分钟" + sequencer.getTempoInBPM() + "小节");
					System.out.println("当前位置,第" + sequencer.getTickPosition() + "拍");
					System.out.println("----------------------------");
					System.out.println("----------------------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("睡眠阻塞出现异常");
					}
				}
			}
		};
		t1.start();
	}

	/**
	 * 加载文件
	 * 
	 * @return
	 */
	public static Sequencer MidiGo( int track) {
		Sequencer sequencer = null;
		Sequence sequence;
		try {
			sequence = MidiSystem.getSequence(new File("C:\\Users\\Administrator\\Desktop\\MyMIDI.mid"));
			sequencer = MidiSystem.getSequencer();
			tracks = sequence.getTracks()[track];
			if (sequencer == null) {
				throw new IOException("未找到可用序列化！");
			}
			getMessage(tracks);
			sequencer.open();
			sequencer.setSequence(sequence);
			return sequencer;
		} catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
			e.printStackTrace();
			try {
				sequencer.close();
			} catch (Exception e2) {
				System.out.println("序列化音序器关闭时发生异常!");
			}
			return sequencer;
		}
	}

	/**
	 * 获取当前MIDI信息
	 */
	public static void getMidiInFo() {
		Info[] infos = MidiSystem.getMidiDeviceInfo();
		int index = 1;
		System.out.println("--------当前Midi信息--------");
		for (Info info : infos) {
			System.out.println("第" + index++ + "信息");
			System.out.println("\t" + info.getName());
			System.out.println("\t" + info.getVendor());
			System.out.println("\t" + info.getVersion());
			System.out.println("\t" + info.getDescription());
		}
		System.out.println("---------------------------");
	}

	/**
	 * 捕获指定轨道Message
	 */
	public static void getMessage(Track track) {
		for (int i = 0; i < track.size(); i++) {
			event = track.get(i);
			message = event.getMessage();
			receiver.send(message, System.currentTimeMillis());
//			getTick(sequencer, true, 1, 2.0f);
			getMidiInFo();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}