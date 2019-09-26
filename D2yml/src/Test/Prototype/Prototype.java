package Test.Prototype;


public class Prototype {
	public static void main(String[] args) {
		Bean b = new Bean();
		b.setName("b");
		Bean be = b;
		System.out.println(be.getName());
		be.setName("bb");
		System.out.println(b.getName() +"-"+ be.getName());
	}
}
