package Study.Patterns.Delegate;

public class Manager {
	public static boolean accept(String i) {
		byte[] bytes = i.getBytes();
		for (byte b : bytes) {
			if (b % 2 == 0) {
				Execute1.working();
			} else {
				Execute2.working();
			}
		}
		System.out.println("我好了");
		return true;
	}
}
