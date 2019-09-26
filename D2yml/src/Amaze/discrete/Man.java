package Amaze.discrete;

public class Man {
	private String from;
	private String house;
	private String somke;
	private String drinks;
	private String Pets;
	
	@Override
	public String toString() {
		return "Man [from=" + from + ", house=" + house + ", somke=" + somke + ", drinks=" + drinks + ", Pets=" + Pets
				+ "]";
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getSomke() {
		return somke;
	}
	public void setSomke(String somke) {
		this.somke = somke;
	}
	public String getDrinks() {
		return drinks;
	}
	public void setDrinks(String drinks) {
		this.drinks = drinks;
	}
	public String getPets() {
		return Pets;
	}
	public void setPets(String pets) {
		Pets = pets;
	}
	
}
