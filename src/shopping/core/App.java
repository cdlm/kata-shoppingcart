package shopping.core;

public class App {
	
	public static void main(String[] args) {
		Product bier = new Product("Bier", 3);
		Product pizza = new Product("Pizza",6);
		
		Cart cart = new Cart();
		cart.add(new RegularItem(bier, 6));
		cart.add(new BundledItem(pizza, 5, 2, 4));
		
		System.out.println(cart);
	}

}
