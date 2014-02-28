package shopping.core;
public class BundledItem extends CartItem {

    private final int bundleSize;
    private final int paidQuantity;

    public BundledItem(Product p, int qty, int paidQuantity, int bundleSize) {
        super(p,qty);
        this.bundleSize = bundleSize;
        this.paidQuantity = paidQuantity;
    }


	@Override
	protected String itemType() {
		return "Bundled Item";
	}

	@Override
	float totalPrice() {
	    float bundles = quantity / bundleSize;
        float remainder = quantity % bundleSize;
        return (bundles * paidQuantity + remainder) * unitPrice();
	}
}