package shopping.core;

public abstract class CartItem {
    
	protected Product product;
	protected int quantity;
	
	public CartItem(Product p, int qty) {
		product = p;
		quantity = qty;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public float unitPrice() {
		return product.unitPrice();
	}
	public String description() {
		return itemType() + "("+ product.description() + 
				"," + quantity + 
				"," + unitPrice()+ ")"; 
	}
	
	
	public boolean decreaseQty(int delta) {
		if (quantity - delta > 0) {
			quantity -= delta;
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public void increaseQty(int delta) {
		quantity += delta;
	}
	
	
	abstract protected String itemType();	
	
	abstract float price();
    
}
