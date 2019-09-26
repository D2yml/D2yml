package Study.Patterns.Template;

public abstract class Cooking {
	
	public void doing() {
		hotOil();
		setMain();
		detail();
		withSalt();
	}

	protected abstract void detail();

	protected abstract void setMain();

	private void hotOil() {
		System.out.println("小葱熟个锅");
	};

	private void withSalt() {
		System.out.println("加盐出锅");
	};
	
	
}
