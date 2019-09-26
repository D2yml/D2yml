package MyMIDI.util;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import MyMIDI.main;

public class BPM {
	static Float BPMdefault = null;
	public static float getBPM(Sequencer sequencer) {
		float tempoInBPM = sequencer.getTempoInBPM();
		System.out.println("当前BPM:"+tempoInBPM);
		if (BPMdefault == null) {
			BPMdefault = tempoInBPM;
		}
		return tempoInBPM;
	}

	public static void setBPM(Sequencer sequencer, String input) {
		if ("default".equals(input)) {
			if (BPMdefault == null) {
				System.out.println("当前BPM已是默认状态");
			} else {
				sequencer.setTempoInBPM(BPMdefault);
			}
		} else {
			if (BPMdefault == null) {
				BPMdefault = sequencer.getTempoInBPM();
			}
			try {
				sequencer.setTempoInBPM(Float.parseFloat(input + "f"));	
				System.out.println("设置成功 ! ");
			} catch (NumberFormatException e) {
				System.err.println("请按照正确格式输入 ! ");
			}
		}
	}
}
