package Study.Patterns.Proxy;

public class Costomer implements Ins {
	private int hight = 180;

	private int bodyWeight = 150;

	@Override
	public void inputSize() {
		System.out.println("身高:" + hight + ";体重:" + bodyWeight);
		System.out.println("该穿什么号合适");
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public int getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
}
