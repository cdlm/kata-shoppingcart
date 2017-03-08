package shopping.core;

import java.util.LinkedList;
import java.util.List;

public class Cart {

  protected List<CartItem> items;

  public Cart() {
    items = new LinkedList<CartItem>();
  }

  public int total() {
    int result = 0;
    for (CartItem each : items) {
      result = result + each.price();
    }
    return result;
  }

  public void clear() {
    items.clear();
  }

  public void add(CartItem item) {
    items.add(item);
  }

  public void remove(CartItem item) {
    items.remove(item);
  }

  public int quantity(Product product) {
    int sum = 0;
    for (CartItem item : items) {
      if (item.getProduct().equals(product)) {
        sum = sum + item.getQuantity();
      }
    }
    return sum;
  }

  public List<CartItem> priceGreater(int amount) {
    List<CartItem> result = new LinkedList<CartItem>();

    for (CartItem item : items) {
      if (item.price() > amount) {
        result.add(item);
      }
    }
    return result;
  }

  @Override
  public String toString() {
    String line = "--------------------------------\n";
    StringBuffer sb = new StringBuffer();
    sb.append(line);
    for (CartItem each : items) {
      sb.append(String.format("%-24s\t%8.2f\n", each.description(), each.price() / 100.0));

    }
    sb.append(line);
    sb.append(String.format("%24s\t%8.2f", "TOTAL:", total() / 100.0));
    return sb.toString();
  }
}
