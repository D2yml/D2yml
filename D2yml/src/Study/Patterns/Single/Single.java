package Study.Patterns.Single;

public class Single {
	
	
	
	private Single() {};
	
	private static class initialize{
		private static final String getInitialize() {
			return "OK";
		} 
	}
	
	public static String getSingle() {
		return initialize.getInitialize();
	}
}
