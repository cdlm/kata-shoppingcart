package shopping.pricing;

import shopping.core.Item;

public class PromotionPricing extends PricingPolicy {

    private final double priceFactor;

    public PromotionPricing(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public int priceForQuantity(int quantity) {
        return (int) (super.priceForQuantity(quantity) * priceFactor);
    }
}
