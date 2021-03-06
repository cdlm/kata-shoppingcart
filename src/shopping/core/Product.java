package shopping.core;

public class Product implements Item {

    private final String description;
    private final int unitPrice;

    public Product(String description, int priceInCents) {
        this.description = description;
        this.unitPrice = priceInCents;
    }

    public int unitPrice() {
        return unitPrice;
    }

    public String description() {
        return description;
    }

    public int priceForQuantity(int quantity) {
        return unitPrice * quantity;
    }
}
