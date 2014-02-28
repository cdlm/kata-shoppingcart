package shopping.core;

public class RegularItem extends CartItem {

	public RegularItem(Product p, int qty) {
		super(p, qty);
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
