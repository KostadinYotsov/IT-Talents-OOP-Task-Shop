package Shop;

import java.util.Random;

public class ProductNum  extends Product {

	private int num;

	public ProductNum(String name, double price, int num) {
		super(name,price);
		if (num>0) {
			this.num=num;
		}
		else {
			num=10;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.num + " quantity.";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
