package shopping.core;

public class PricingPolicy implements Item {

    private final Item baseItem;

    public PricingPolicy(Item baseItem) {
        this.baseItem = baseItem;
    }

    public int unitPrice() { return baseItem.unitPrice(); }

    public String description() { return baseItem.description(); }

    public int priceForQuantity(int quantity) {
        return baseItem.priceForQuantity(quantity);
    }
}
