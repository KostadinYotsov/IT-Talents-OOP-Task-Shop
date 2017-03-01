package Buyer;

import java.util.Arrays;

import Shop.Product;
import Shop.ProductKG;
import Shop.ProductNum;
import Shop.Shop;

public class Buyer {
	
	private String name;
	private Shop shop;
	private double money;
	private Product [] buyProducts;
	private int productIdx=0;
	
	public Buyer(String name, double money) {
		if (!name.trim().isEmpty() || name!=null) {
			this.name = name;	
		}
		else {
			this.name = "Phantom product";
		}
		if (money>0) {
			this.money=money;
		}
		else {
			this.money=200;
		}
		this.buyProducts=new Product [5];
	}
	
	public void addShop (Shop shop) {
		if (shop!=null) {
			this.shop=shop;
		}
	}
	
	public void addPKg (String ProductKgName, double kg) {
		if ( this.productIdx<this.buyProducts.length) {
			Product [] pro=shop.getProducts();
			for (int i = 0; i <pro.length; i++) {
				if (pro[i].getName().equals(ProductKgName)) {
					shop.removePKg(pro[i], kg);
					this.buyProducts[productIdx]=pro[i];
					ProductKG p=(ProductKG) this.buyProducts[productIdx++];
					p.setKg(kg);
					break;
				}
			}
		}
	}
	
	public void addPNum (String ProductNumName, int num) {
		if ( this.productIdx<this.buyProducts.length) {
			Product [] pro=shop.getProducts();
			for (int i = 0; i <pro.length; i++) {
				if (pro[i].getName().equals(ProductNumName)) {
					Product p= pro[i];
					this.buyProducts[productIdx++]=p;
					shop.removePNum(p, num);
					break;
				}
			}
		}
	}
	
	public void pay () {
		double moneyFromPay=0;
		for (int i = 0; i < buyProducts.length; i++) {
			if (buyProducts[i]!=null) {
				if (buyProducts [i] instanceof ProductKG) {
					ProductKG prKg=(ProductKG) buyProducts[i];
					this.money-=prKg.getPrice()*prKg.getKg();
					moneyFromPay+=prKg.getPrice()*prKg.getKg();
				}
				else {
					ProductNum prNum=(ProductNum) buyProducts[i];
					this.money-=prNum.getPrice()*prNum.getNum();
					moneyFromPay+=prNum.getPrice()*prNum.getNum();
				}
			}	
		}
		this.shop.setMoneyInBank(shop.getMoneyInBank() + moneyFromPay);
	}

	@Override
	public String toString() {
		return "Buyer [name=" + name + ", money=" + money + ", products=" + Arrays.toString(buyProducts) + "]";
	}

	
	
}
