package MyMIDI.util;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Midi {
	static Sequencer player = null;
//	static Sequence sequence = null;

	public static void main(String[] args) {
		Midi mini = new Midi();
//		try {
//			sequence = MidiSystem.getSequence(new File("C:\\Users\\Administrator\\Desktop\\MyMIDI.mid"));
//			player = MidiSystem.getSequencer();
//			player.open();
//			player.setSequence(sequence);
//			player.start();
//			message();
//		} catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
//			e.printStackTrace();
//		}
		int[] sky = new int[] {57,59,60,59,60};
		mini.play(25, sky);
//		mini.play(25, 62);
		
//		mini.play();
		
	}

	private static void message() {
		try {
			player.getTransmitter().setReceiver(new Receiver() {

				@Override
				public void send(MidiMessage message, long timeStamp) {
					
				}

				@Override
				public void close() {
				}
			});
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void play() {
		try {
			player = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		try {
			// Get a sequencer and open it
			// 得到一个序列化音序器
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 8,3); // Treat the arguments as Ready-bake arguments

			Track track = seq.createTrack(); // Ask the sequence for a track

			// Put some MidiEvents into the Track, the setMessage() method is what we should
			// really care
			ShortMessage a = new ShortMessage();
			// 第一个参数:设置Midi命令
			// 第二个参数:设置事件所在的音轨下标(0-15)
			// 第三个参数:设置事件音高下标(0-127)
			// 第四个参数:设置事件音量下标(0-100)
//			a.setMessage(144, 1, *20*, 100);
			a.setMessage(144, 1, 1, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

//			a.setMessage(128, 1, 1, 100);
//			MidiEvent noteOn2 = new MidiEvent(a, 8);
//			track.add(noteOn2);

			ShortMessage b = new ShortMessage();
			b.setMessage(144, 2, 60, 100);
			MidiEvent noteOff = new MidiEvent(b, 2);
			track.add(noteOff);

//			a.setMessage(128, 2, 60, 100);
//			MidiEvent noteOn3 = new MidiEvent(a, 16);
//			track.add(noteOn3);

			player.setSequence(seq); // Give the sequence to the Sequencer
										// like pushing a CD to a CD player

			player.start(); // Start the sequencer like pushing PLAY
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (!player.isRunning()) {
				player.stop();
				player.close();
			}
		}
	} // Close play

	/**
	 * 
	 * @param instrument 音色
	 * @param note 音调
	 */
	public void play(int instrument, int[] note) {
		try {
			// Get a sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(0.0f, 1); // Treat the arguments as Ready-bake arguments
			Track track = seq.createTrack(); // Ask the sequence for a track

			MidiEvent event = null;

			// Put some MidiEvents into the Track, the setMessage() method is what we should
			// really care
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 5);
			track.add(changeInstrument);

//			for (int i = 0; i < note.length; i++) {
				ShortMessage a = new ShortMessage();
				a.setMessage(144, 1, 57, 100);
				MidiEvent noteOn1 = new MidiEvent(a, 1);
				track.add(noteOn1);

				ShortMessage b = new ShortMessage();
				b.setMessage(128, 1, 57, 100);
				MidiEvent noteOff1 = new MidiEvent(b, 2);
				track.add(noteOff1);
				
				ShortMessage c = new ShortMessage();
				a.setMessage(144, 1, 59, 100);
				MidiEvent noteOn2 = new MidiEvent(c, 1);
				track.add(noteOn2);

				ShortMessage d = new ShortMessage();
				b.setMessage(128, 1, 59, 100);
				MidiEvent noteOff2 = new MidiEvent(d, 2);
				track.add(noteOff2);
				
				ShortMessage e = new ShortMessage();
				a.setMessage(144, 1, 1, 100);
				MidiEvent noteOn3 = new MidiEvent(e, 1);
				track.add(noteOn3);

				ShortMessage f = new ShortMessage();
				b.setMessage(128, 1, 44, 100);
				MidiEvent noteOff3 = new MidiEvent(f, 4);
				track.add(noteOff3);
//			}

			player.setSequence(seq); // Give the sequence to the Sequencer
										// like pushing a CD to a CD player
			MidiEvent midiEvent = track.get(4);
			MidiMessage message = midiEvent.getMessage();
			System.out.println(message.getStatus());
			player.start(); // Start the sequencer like pushing PLAY
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	} // Close play
	private static void createKey(Track track,int index) throws InvalidMidiDataException {
		ShortMessage a = new ShortMessage();
		a.setMessage(144, 1, index, 100);
		MidiEvent noteOn1 = new MidiEvent(a, 1);
		track.add(noteOn1);

		ShortMessage b = new ShortMessage();
		b.setMessage(128, 1, index, 100);
		MidiEvent noteOff1 = new MidiEvent(b, 4);
		track.add(noteOff1);
	}

}
