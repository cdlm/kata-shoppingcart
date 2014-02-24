package shopping.core;

public class BundlePricedItem extends BasicPricedItem {

    private final int bundleSize;
    private final int pricedQuantity;

    public BundlePricedItem(String description, int priceInCents, int bundleSize, int pricedQuantity) {
        super(description, priceInCents);
        this.bundleSize = bundleSize;
        this.pricedQuantity = pricedQuantity;
    }

    @Override
    public int priceForQuantity(int howMany) {
        int bundles = howMany / bundleSize;
        int remainder = howMany % bundleSize;
        return (bundles * pricedQuantity + remainder) * unitPrice();
    }
}
