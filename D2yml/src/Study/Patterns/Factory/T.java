package Study.Patterns.Factory;

public class T {
	public static void main(String[] args) {
		
		BassFactory bass = new Dingwall();
		
		System.out.println(bass);
	}
}
