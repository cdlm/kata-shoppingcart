package shopping.core;

import shopping.core.CartItem;

public class DegressiveItem extends CartItem {
    private final int thresholdQuantity;
    private final float reducedUnitPrice;

    public DegressiveItem(Product p, int qty, int thresholdQuantity, float reducedUnitPrice) {
        super(p, qty);
        this.thresholdQuantity = thresholdQuantity;
        this.reducedUnitPrice = reducedUnitPrice;
    }


	@Override
	protected String itemType() {
		return "Degressive Item";
	}

	@Override
	float totalPrice() {
		if (quantity < thresholdQuantity) {
            return unitPrice() * quantity;
        } else {
            return reducedUnitPrice * quantity;
        }
	}
}
