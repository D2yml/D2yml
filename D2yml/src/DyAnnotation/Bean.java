package DyAnnotation;

import DyAnnotation.Brand.BrandFactory;

public class Bean {
	
	@Name("凤凰战士")
	private String name;
	@Brand(brand = BrandFactory.KILLER)
	private String Brand;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	
	
}
