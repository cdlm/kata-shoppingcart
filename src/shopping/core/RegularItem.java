package shopping.core;

public class RegularItem extends CartItem {

  public RegularItem(Product p, int qty) {
    super(p, qty);
  }

  @Override
  int price() {
    return unitPrice() * quantity;
  }

  @Override
  protected String itemType() {
    return "Regular Item";
  }

}
