package shopping.core.decorator;

public class DegressiveItem extends DecoratedCartItem {
    private final int thresholdQuantity;
    private final float reducedUnitPrice;

    public DegressiveItem(CartItem item, int thresholdQuantity, float reducedUnitPrice) {
        super(item);
        this.thresholdQuantity = thresholdQuantity;
        this.reducedUnitPrice = reducedUnitPrice;
    }
 

    @Override
	protected String itemType() {
		return "Degressive Item";
	}

    @Override
	public float totalPrice() {
		float quantity = getQuantity();
		if (quantity < thresholdQuantity) {
            return unitPrice() * quantity;
        } else {
            return reducedUnitPrice * quantity;
        }
	}
}