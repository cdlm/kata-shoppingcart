package shopping.core;
public class BundledItem extends CartItem {

    private final int bundleSize;
    private final int paidQuantity;

    public BundledItem(Product p, int qty, int bundleSize,int paidQuantity) {
        super(p,qty);
        this.bundleSize = bundleSize;
        this.paidQuantity = paidQuantity;
    }


	@Override
	protected String itemType() {
		return "Bundled Item";
	}

	@Override
    public float price() {
	    int completeBundles = quantity / bundleSize;
        int remainder = quantity % bundleSize;
        return (completeBundles * paidQuantity + remainder) * unitPrice();
	}
}
