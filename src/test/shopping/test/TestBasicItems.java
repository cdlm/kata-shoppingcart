package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.ShoppingCart;
import shopping.core.CartItem;
import shopping.core.Product;
import shopping.core.RegularItem;

import static org.junit.Assert.assertEquals;

public class TestBasicItems {

  private ShoppingCart cart;
  private Product product;
  private CartItem item1;
  private CartItem item2;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    product = new Product("Cheese", 300);
    item1 = new RegularItem(product, 2);
    Product product2 = new Product("Bier", 150);
    item2 = new RegularItem(product2, 6);
  }


  @Test
  public void singleBasicItemCostsItsUnitPrice() {
    cart.clear();
    cart.add(item1);
    assertEquals(300*2, cart.total());
  }

  @Test
  public void multipleBasicItemsCostProportionally() {
    cart.clear();
    cart.add(item1);
    cart.add(item2);
    assertEquals(300 * 2 + 150 * 6, cart.total());
  }

  @Test
  public void separatelyAdding() {
    int howMany = 3;
    for (int i = howMany; i > 0; i--) {
      cart.add(new RegularItem(product, 1));
    }
    assertEquals(howMany * 300, cart.total());
  }

}
