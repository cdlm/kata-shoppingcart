package shopping.core;

public class Product {

  private String description;
  private int unitPrice;

  public Product(String description, int unitPrice) {
    this.description = description;
    this.unitPrice = unitPrice;
  }

  public int unitPrice() {
    return unitPrice;
  }

  public String description() {
    return description;
  }
}
