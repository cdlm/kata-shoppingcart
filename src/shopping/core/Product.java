package shopping.core;

public class Product  {

    private  String description;
    private  double unitPrice;

    public Product(String description, double d) {
        this.description = description;
        this.unitPrice = d;
    }

    public float unitPrice() {
        return unitPrice;
    }

    public String description() {
        return description;
    }
}
