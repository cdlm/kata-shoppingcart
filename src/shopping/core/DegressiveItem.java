package shopping.core;

public class DegressiveItem extends CartItem {

  private final int thresholdQuantity;
  private final int reducedUnitPrice;

  public DegressiveItem(Product p, int qty, int thresholdQuantity, int reducedUnitPrice) {
    super(p, qty);
    this.thresholdQuantity = thresholdQuantity;
    this.reducedUnitPrice = reducedUnitPrice;
  }


  @Override
  protected String itemType() {
    return "Degressive Item";
  }

  @Override
  int price() {
    if (quantity < thresholdQuantity) {
      return unitPrice() * quantity;
    } else {
      return reducedUnitPrice * quantity;
    }
  }
}
