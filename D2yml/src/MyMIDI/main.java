package MyMIDI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


import MyMIDI.util.BPM;
import MyMIDI.util.MENU;

public class main {
	private static List<String> list = new ArrayList();
	static {
		list.add("打开帮助菜单  :   help");
		list.add("开始播放  : Start");
		list.add("停止播放 :  Stop");
		list.add("设置播放次数  :   while:?");
		list.add("获取当前BPM : getBPM");
		list.add("设置当前BPM : setBPM:???.??");
		
	}
	volatile static String input = null;// 用户输入
	static Sequence sequence = null;
	static Sequencer sequencer = null;

	public static void main(String[] args) {

		try {
			player();
			scanner();
			readInput();
		} catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	public static void player() throws InvalidMidiDataException, IOException, MidiUnavailableException {
			sequence = MidiSystem.getSequence(new File("C:\\Users\\Administrator\\Desktop\\MyMIDI.mid"));
			if (sequence == null) {
				throw new IOException("加载文件失败");
			}
			sequencer = MidiSystem.getSequencer();
			if (sequencer == null) {
				throw new IOException("未找到可用音序器！");
			}
			sequencer.setSequence(sequence);
			sequencer.open();
			sequencer.start();
	} 

	public static void readInput() {
		Thread readInput = new Thread() {
			public void run() {
				while (sequencer.isRunning()) {
					if (input != null) {
						String[] strArr = input.split(":");
						switch (strArr[0]) {
						case "help":
							help();
							input = null;
							break;
						case "getBPM":
							BPM.getBPM(sequencer);
							input = null;
							break;
						case "setBPM":
							BPM.setBPM(sequencer, strArr[1]);
							input = null;
							break;
						case "while":
							MENU.MidiWhile(sequencer, strArr[1]);
							input = null;
							break;
						case "Start":
							MENU.MidiStart(sequencer);
							input = null;
							break;
						case "Stop":
							MENU.MidiStop(sequencer);
							input = null;
							break;
						default:
							System.out.println("无效的指令");
							input = null;
							break;
						}
					}
				}
				
			}
		};
		readInput.setDaemon(true);
		readInput.start();
		
	}
	private static void help() {
		for (String string : list) {
			System.out.println(string);
		}
	}

	public static void getBPM() {

		Thread BPM = new Thread() {
			public void run() {
				while (sequencer.isRunning()) {
					if ("getBPM".equals(input)) {
						float tempoInBPM = sequencer.getTempoInBPM();
						System.out.println(tempoInBPM);
						main.input = null;
					}
				}
			}
		};
		BPM.setDaemon(true);
		BPM.start();
	}

	public static void setBPM() {
		Thread BPM = new Thread() {
			public void run() {
				while (sequencer.isRunning()) {
					if (input != null && !"".equals(input)) {
						String[] str = input.split(":");
						if ("setBPM".equals(str[0])) {
							sequencer.setTempoInBPM(Float.parseFloat(str[1] + "f"));
							main.input = null;
						}
					}
				}

			}
		};
		BPM.setDaemon(true);
		BPM.start();
	}

	private static void scanner() {
		final Scanner Sc = new Scanner(System.in);
		Thread input = new Thread() {
			public void run() {
				System.out.println("输入\"help\"查看指令");
				while (sequencer.isRunning()) {
					String str = Sc.next();
					if (str != null && !"".equals(str)) {
						main.input = str;
					}
				}
			}
		};
		input.setDaemon(true);
		input.start();
	}
}
