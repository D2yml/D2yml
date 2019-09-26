package Study.Patterns.Template;

public class Chicken extends Cooking{

	@Override
	protected void detail() {
		System.out.println("起锅热油...");
		System.out.println("炸至表面金黄");
	}

	@Override
	protected void setMain() {
		System.out.println("弄只鸡");
	}

}
