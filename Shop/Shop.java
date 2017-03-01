package Shop;

import java.util.ArrayList;

public class Shop {

	private String name;
	private String adress;
	private double moneyInBank;
	private Product [] products;
	private int addedProductIdx=0;
	
	public Shop(String name, String adress) {
		if (!name.trim().isEmpty() || name!=null) {
			this.name = name;	
		}
		else {
			this.name = "Phantom shop";
		}
		if (!adress.trim().isEmpty() || name!=null) {
			this.adress = adress;	
		}
		else {
			this.adress = "Bul Vitosha 007";
		}
		this.moneyInBank = 200;
		this.products = new Product[10];
	}
	
	public void addProduct(Product p) {
		if (p!=null && addedProductIdx<products.length) {
			products[addedProductIdx++]=p;
		}
	}
	
	public void printInfo () {
		System.out.println(this.name + " - " +  this.adress);
		for (int i = 0; i < products.length; i++) {
			if (products[i]!=null) {
				System.out.println(products[i].toString());
			}
		}
		System.out.println("Money in bank : " + this.moneyInBank);
		System.out.println();
	}
	
	public Product [] getProducts () {
		Product[] pro =products.clone();
		return pro;
	}
	
	public void removePKg (Product p, double kg) {
		if (p!=null) {
			for (int i = 0; i < products.length; i++) {
				if (products[i]!= null && products[i]==p) {
					ProductKG pro=(ProductKG) products[i];
					if (pro.getKg()<kg) {
						System.out.println("Nqma tezi kilogrami v nalichnost.");
						System.out.println("Ostanali sa " + pro.getKg() + " kg.");
					}
					else {
						pro.setKg(pro.getKg()-kg);
						if (pro.getKg()==0) {
							pro=null;
						}
					}
				}
			}
		}
	}

	public void removePNum(Product p, int num) {
		if (p!=null) {
			for (int i = 0; i < products.length; i++) {
				if (products[i]!= null && products[i]==p) {
					ProductNum pro=(ProductNum) products[i];
					if (pro.getNum()<num) {
						System.out.println("Nqma tazi broika v nalichnost.");
						System.out.println("Ostanali sa " + pro.getNum() + " broiki.");
					}
					else {
						pro.setNum(pro.getNum()-num);
						if (pro.getNum()==0) {
							pro=null;
						}
					}
				}
			}
		}
	}

	public void setMoneyInBank(double moneyInBank) {
		this.moneyInBank = moneyInBank;
	}

	public double getMoneyInBank() {
		return moneyInBank;
	}
	
	
}
