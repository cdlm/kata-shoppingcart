package shopping.core;

public abstract class PricingPolicy implements Item {

    private final Item baseItem;

    public PricingPolicy(Item baseItem) {
        this.baseItem = baseItem;
    }

    public int unitPrice() { return baseItem.unitPrice(); }
    public String description() { return baseItem.description(); }
}
