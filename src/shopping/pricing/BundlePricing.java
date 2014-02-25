package shopping.pricing;

import shopping.core.Item;

public class BundlePricing extends PricingPolicy {

    private final int bundleSize;
    private final int paidQuantity;

    public BundlePricing(Item baseItem, int bundleSize, int paidQuantity) {
        super(baseItem);
        this.bundleSize = bundleSize;
        this.paidQuantity = paidQuantity;
    }

    @Override
    public int priceForQuantity(int howMany) {
        int bundles = howMany / bundleSize;
        int remainder = howMany % bundleSize;
        return (bundles * paidQuantity + remainder) * unitPrice();
    }
}
