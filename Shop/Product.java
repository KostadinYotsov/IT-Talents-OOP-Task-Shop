package Shop;

import java.util.Random;

public abstract class Product {

	private String name;
	private double price;

	
	public Product(String name, double price) {
		if (!name.trim().isEmpty() || name!=null) {
			this.name = name;	
		}
		else {
			this.name = "Phantom product";
		}
		if (price>0) {
			this.price=price;
		}
		else {
			this.price=2.75;
		}
	}
	
	public String getName () {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public double getPrice() {
		return price;
	}

	
	
}
