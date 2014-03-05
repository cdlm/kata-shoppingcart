package shopping.core;

import shopping.core.CartItem;

public class ReducedPriceItem extends CartItem {

    private final float priceFactor;

    public ReducedPriceItem(Product p, int qty, int percentPromotion) {
        super(p, qty);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("reduction must be in [0,100]");
        }
        this.priceFactor = (float) ((100 - percentPromotion) / 100.0);
    }

	@Override
	protected String itemType() {
		return "Reduced Item";
	}

	@Override
	double price() {
		double normalPrice = unitPrice() * quantity;
		return (int) (normalPrice * priceFactor);
	}
}
