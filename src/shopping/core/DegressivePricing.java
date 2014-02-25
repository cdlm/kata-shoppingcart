package shopping.core;

public class DegressivePricing extends PricingPolicy {
    private final int thresholdQuantity;
    private final int reducedUnitPrice;

    public DegressivePricing(Item baseItem, int thresholdQuantity, int reducedUnitPrice) {
        super(baseItem);
        this.thresholdQuantity = thresholdQuantity;
        this.reducedUnitPrice = reducedUnitPrice;
    }

    @Override
    public int priceForQuantity(int quantity) {
        if (quantity < thresholdQuantity) {
            return super.priceForQuantity(quantity);
        } else {
            return reducedUnitPrice * quantity;
        }
    }
}
