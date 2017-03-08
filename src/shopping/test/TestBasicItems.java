package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.Cart;
import shopping.core.CartItem;
import shopping.core.Product;
import shopping.core.RegularItem;

import static org.junit.Assert.assertEquals;

public class TestBasicItems {

  private Cart cart;
  private Product product1;
  private Product product2;
  private CartItem item1;
  private CartItem item2;

  @Before
  public void setUp() {
    cart = new Cart();
    product1 = new Product("Cheese", 300);
    item1 = new RegularItem(product1, 2);
    product2 = new Product("Bier", 150);
    item2 = new RegularItem(product2, 6);
  }


  @Test
  public void test_singleBasicItemCostsItsUnitPrice() {
    cart.clear();
    cart.add(item1);
    assertEquals(300*2, cart.total());
  }

  @Test
  public void test_multipleBasicItemsCostProportionally() {
    cart.clear();
    cart.add(item1);
    cart.add(item2);
    assertEquals(300 * 2 + 150 * 6, cart.total());
  }

  @Test
  public void test_separatelyAdding() {
    int howMany = 3;
    for (int i = howMany; i > 0; i--) {
      cart.add(new RegularItem(product1, 1));
    }
    assertEquals(howMany * 300, cart.total());
  }

}
