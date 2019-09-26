package MyMIDI.util;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Midi2 {
	private static int tick = 0;

	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			// 节拍器
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

//	            int r=0;
//	            for(int i=0; i<60; i+=4){
//	                r = (int)((Math.random()*50)+1);    //随即音符
//	                track.add(makeEvent(144, 1, r, 100, i));
//	                track.add(makeEvent(128, 1, r, 100, i+2));
//	            }
				track.add(makeEvent(192, 1, 2, 100, 0));
				addTrack(track, 60, 1, 800);
//				run1645(track);
//	            
//	            track.add(makeEvent(144, 1, 57, 100, tick));
//	            track.add(makeEvent(128, 1, 57, 100, tick+=2));
//	            
//	            track.add(makeEvent(144, 1, 59, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 59, 100, tick+=2));
//	            
//	            track.add(makeEvent(144, 1, 60, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 60, 100, tick+=6));
//	            
//	            track.add(makeEvent(144, 1, 59, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 59, 100, tick+=2));
//	            
//	            track.add(makeEvent(144, 1, 60, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 60, 100, tick+=4));
//	            
//	            track.add(makeEvent(144, 1, 64, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 64, 100, tick+=4));
//	            
//	            track.add(makeEvent(144, 1, 52, 100, tick+=2));
//	            track.add(makeEvent(128, 1, 52, 100, tick+=8));

			player.setSequence(seq);
//	            player.setLoopCount(player.LOOP_CONTINUOUSLY);    //指定无穷的重复次数
			player.setLoopCount(0);
			player.setTempoInBPM(120);
			player.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void addTrack(Track track, int pitch, int startTick, int stopTick) {
		track.add(makeEvent(144, 1, pitch, 100, tick += startTick));
		track.add(makeEvent(128, 1, pitch, 100, tick += stopTick));
	}

	/**
	 * 
	 * MidiEvent是组合乐曲的指令,一连串的MidiEvent就好像是乐谱一样.
	 * MidiEvent用来指示在何时执行什么操作,每个指令都必须包括该指令的执行时机.也就是说,乐声应该在那一拍发响.
	 * 
	 * @param comd chmod代表信息类型 144类型的信息代表NOTE ON表示打开 128代表NOTE OFF 表示关闭
	 * @param chan chan表示频道,每个频道代表不同的演奏者.
	 *             例如:一号频道是吉他,二号频道是Bass.或者可以像IronMaiden用3把不同音色的吉他编制
	 * @param one  one表示音符,从0~127代表不同音高
	 * @param two  two代表音道/音量,用多大的音道按下? 0几乎听不到,100算是差不多
	 * @param tick
	 * @return
	 */
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			// 表示在tick拍启动a这个Message
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	public static void main(String[] args) {
		Midi2 mini = new Midi2();
		mini.play();

	}

	public static void sky(Track track) {
		addTrack(track, 57, 0, 2);
		addTrack(track, 59, 2, 2);
		addTrack(track, 60, 2, 6);
		addTrack(track, 59, 2, 2);
		addTrack(track, 60, 2, 4);
		addTrack(track, 64, 2, 4);
		addTrack(track, 52, 2, 8);
	}

	public static void run1645(Track track) {
		//C
		addTrack(track, 60, 0, 2);
		addTrack(track, 64, 2, 2);
		addTrack(track, 67, 2, 2);
		//Cb
		addTrack(track, 48, 2, 2);
		addTrack(track, 52, 2, 2);
		addTrack(track, 55, 2, 2);
		//C
		addTrack(track, 60, 2, 2);
		addTrack(track, 64, 2, 2);
		addTrack(track, 67, 2, 2);
		//E
		addTrack(track, 64, 2, 2);
		addTrack(track, 68, 2, 2);
		addTrack(track, 72, 2, 2);
	}
}
