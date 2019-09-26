package Study.Patterns.Factory;

public class Fender implements Bass,BassFactory{

	public Fender() {
		System.out.println("this is Fender");
	}
	
	@Override
	public String Brand() {
		return "this is Fender";
	}

	@Override
	public Bass getBass() {
		return new Fender();
	}
	
}
