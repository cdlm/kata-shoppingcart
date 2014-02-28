package shopping.core.decorator;

import shopping.core.Product;


public abstract class DecoratedCartItem extends CartItem {

	protected CartItem decoratedItem;

	public DecoratedCartItem(CartItem item) {
		decoratedItem = item;
	}

	@Override
	public Product getProduct() {
		return decoratedItem.getProduct();
	}

	@Override
	public int getQuantity() {
		return decoratedItem.getQuantity();
	}	
	
	
	
}
