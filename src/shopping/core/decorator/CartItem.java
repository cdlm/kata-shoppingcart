package shopping.core.decorator;

import shopping.core.Product;

public abstract class CartItem {
    
	public abstract Product getProduct();

	public abstract int getQuantity();
	
	public float unitPrice()  {
		return getProduct().unitPrice();
	}
	public String description() {
		return itemType() + "("+ getProduct().description() + 
				"," + getQuantity() + 
				"," + unitPrice()+ ")"; }
	
	abstract protected String itemType();	
	
	abstract float totalPrice();
    
}
