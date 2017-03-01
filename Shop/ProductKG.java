package Shop;

import java.util.Random;

public abstract  class ProductKG  extends Product {
	
	private double kg;
	
	public ProductKG(String name, double price, double kg) {
		super(name,price);
		if (kg>0) {
			this.kg=kg;
		}
		else {
			this.kg=kg;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.kg + " kg.";
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}
	
	
}
