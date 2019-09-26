package DyStructure;

import DyStructure.List.DyArrList;
import MyMIDI.main;

public class T {
	public static void main(String[] args) {
		DyArrList<String> l = new DyArrList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.remove("3");
		System.out.println(l);
	}
}
