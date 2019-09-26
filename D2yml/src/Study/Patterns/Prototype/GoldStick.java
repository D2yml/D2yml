package Study.Patterns.Prototype;

import java.io.Serializable;

public class GoldStick implements Serializable{
	private int length = 100;
	private int diameter = 3;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	
}
