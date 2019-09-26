package Study.Patterns.Factory;

public class Dingwall implements Bass,BassFactory{

	public Dingwall() {
		System.out.println("this is Dingwall");
	}
	
	@Override
	public String Brand() {
		return "this is Dingwall";
	}

	@Override
	public Bass getBass() {
		return new Dingwall();
	}
	
	
}
