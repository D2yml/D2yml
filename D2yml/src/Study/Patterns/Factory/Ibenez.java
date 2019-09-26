package Study.Patterns.Factory;

public class Ibenez implements Bass,BassFactory{
	
	public Ibenez() {
		System.out.println("this is Ibenez");
	}
	
	@Override
	public String Brand() {
		return "this is Ibenez";
	}

	@Override
	public Bass getBass() {
		return new Ibenez();
	}
	
}
