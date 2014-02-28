package shopping.core.decorator;

import shopping.core.Product;

public class RegularItem extends CartItem {
	protected Product product;
	protected int quantity;
	
	public RegularItem(Product p, int qty) {
		product = p;
		quantity = qty;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	float totalPrice() {
		return unitPrice() * quantity;
	}

	@Override
	protected String itemType() {
		return "Regular Item";
	}
	
	
    
}
