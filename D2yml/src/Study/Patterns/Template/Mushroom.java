package Study.Patterns.Template;

public class Mushroom extends Cooking{

	@Override
	protected void detail() {
		System.out.println("焯水...");
		System.out.println("炒熟");
	}

	@Override
	protected void setMain() {
		System.out.println("咱做个蘑菇，放点蘑菇");
	}

}
