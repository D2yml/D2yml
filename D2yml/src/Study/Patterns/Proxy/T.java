package Study.Patterns.Proxy;


public class T {
	public static void main(String[] args) {
		Ins ins = (Ins)new MyInvocationHandler().getIns(new Costomer());
		ins.inputSize();
		System.out.println("over");
	}
}
