package MyMIDI;

import java.util.Date;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MyReceiver implements Receiver{

	@Override
	public void send(MidiMessage message, long timeStamp) {
		System.out.println("-----当前时间"+new Date(timeStamp)+"-----");
		System.out.println("接收到midi信息，类型是 " + message.getClass().getSimpleName());
		System.out.println("接收到midi信息，状态是 " + message.getStatus());
		System.out.println("--------------------------------------------");
	}

	@Override
	public void close() {
		System.out.println("Midi接收器被关闭！");
	}

}
