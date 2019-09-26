package MyMIDI.t;

import javax.sound.midi.*;

public class MiniMusicCmdLine {
	public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
//        if (args.length < 2) {
//            System.out.println("Don't forget the instrum and note args");
//        } else {
            int instrument = 118; //Integer.parseInt(args[0]);
            int note = 21; //Integer.parseInt(args[1]);
            mini.play(instrument, note);
//        }

    }

    public void play(int instrument, int note) {
        try {
            // Get a sequencer and open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4); //Treat the arguments as Ready-bake arguments
            Track track = seq.createTrack(); // Ask the sequence for a track

            MidiEvent event = null;

            // Put some MidiEvents into the Track, the setMessage() method is what we should really care
            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1 ,instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);  

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff); 

            player.setSequence(seq); // Give the sequence to the Sequencer
                                     // like pushing a CD to a CD player

            player.start();  // Start the sequencer like pushing PLAY
        }

        catch(Exception ex) {
            ex.printStackTrace();
        }
    }  // Close play
}
