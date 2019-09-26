package Study.Patterns.Factory;

public class MusicMan implements Bass,BassFactory{

	public MusicMan() {
		System.out.println("this is MusicMan");
	}
	
	@Override
	public String Brand() {
		return "this is Music Man";
	}

	@Override
	public Bass getBass() {
		return new MusicMan();
	}
	
}
