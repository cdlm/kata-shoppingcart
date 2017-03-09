package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.ShoppingCart;
import shopping.core.CartItem;
import shopping.core.Product;
import shopping.core.ReducedPriceItem;

import static org.junit.Assert.assertEquals;

public class TestReducedPriceItems {

  private ShoppingCart cart;
  private Product product;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    product = new Product("something", 1000);
  }

  @Test
  public void promotionAppliesToOne() {
    CartItem reducedItem = new ReducedPriceItem(product, 1, 15);
    cart.add(reducedItem);
    assertEquals(850, cart.total(), 0.0);
  }
}
