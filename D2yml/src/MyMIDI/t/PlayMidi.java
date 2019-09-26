package MyMIDI.t;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import MyMIDI.main;

public class PlayMidi implements Runnable {
	File sound;
	Sequence seq;
	Sequencer midi;
	Thread runner;

	public PlayMidi(String f) {
		try {
			sound = new File(f);
			seq = MidiSystem.getSequence(sound);
			midi = MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
		} catch (Exception ex) {
		}
	}

	public void run() {
		try {
			while (true) {
				if (!midi.isRunning())
					midi.start();
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void playMidi() {
		try {
			// midi.start();
			if (runner == null) {
				runner = new Thread(this);
				runner.start();
			}
		} catch (Exception ex) {
		}
	}

	public void stopMidi() {
		try {
			runner.stop();
			runner = null;
			midi.stop();
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		PlayMidi playMidi1 = new PlayMidi("mytest.mid");
		playMidi1.playMidi();
		playMidi1.stopMidi();
	}
}
