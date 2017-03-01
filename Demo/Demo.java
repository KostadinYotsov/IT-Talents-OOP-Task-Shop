package Demo;

import Buyer.Buyer;
import Shop.Beer;
import Shop.Book;
import Shop.Chair;
import Shop.Cheese;
import Shop.Fish;
import Shop.Meat;
import Shop.Shop;

public class Demo {

	public static void main(String[] args) {

		Shop shop=new Shop("Fantastiko", "ul. Dimitur Stafanov 5");
		
		Meat meat=new Meat (15.50);
		Fish fish=new Fish (20.00);
		Cheese cheese=new Cheese (10.20);
		
		Chair chair=new Chair (10);
		Book book=new Book (20);
		Beer beer=new Beer (50);
		
		shop.addProduct(meat);
		shop.addProduct(fish);
		shop.addProduct(cheese);
		shop.addProduct(chair);
		shop.addProduct(book);
		shop.addProduct(beer);
		
		Buyer pesho=new Buyer("Pesho", 200);
		
		System.out.println(pesho);
		
		shop.printInfo();
		
		pesho.addShop(shop);
		
		pesho.addPKg("Meat", 6);
		pesho.addPKg("Fish", 4);
		
		pesho.addPNum("Beer", 10);
		
		pesho.pay();
		
		System.out.println(pesho);
		
		shop.printInfo();
	
	}

}
