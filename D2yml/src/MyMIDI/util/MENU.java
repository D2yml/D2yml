package MyMIDI.util;

import javax.sound.midi.Sequencer;

public class MENU {
	public static void MidiWhile(Sequencer sequencer,String index) {
		try {
			int i = Integer.valueOf(index);
			if (i < -1) {
				throw new NullPointerException();
			}
			sequencer.setLoopCount(i);
			System.out.println("设置成功 ! ");
		} catch (NumberFormatException e) {
			System.err.println("请输入整数");
		}
	}
	public static void MidiStop(Sequencer sequencer) {
		sequencer.stop();
	}
	public static void MidiStart(Sequencer sequencer) {
		sequencer.start();
	}
}
