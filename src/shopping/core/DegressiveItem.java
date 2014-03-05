package shopping.core;

import shopping.core.CartItem;

public class DegressiveItem extends CartItem {
    private final int thresholdQuantity;
    private final double reducedUnitPrice;

    public DegressiveItem(Product p, int qty, int thresholdQuantity, double reducedUnitPrice) {
        super(p, qty);
        this.thresholdQuantity = thresholdQuantity;
        this.reducedUnitPrice = reducedUnitPrice;
    }


	@Override
	protected String itemType() {
		return "Degressive Item";
	}

	@Override
	double price() {
		if (quantity < thresholdQuantity) {
            return unitPrice() * quantity;
        } else {
            return reducedUnitPrice * quantity;
        }
	}
}
