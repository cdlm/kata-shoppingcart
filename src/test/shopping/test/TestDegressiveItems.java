package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.ShoppingCart;
import shopping.core.CartItem;
import shopping.core.DegressiveItem;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

public class TestDegressiveItems {

  private ShoppingCart cart;
  private Product product;
  private int threshold;
  private int reducedPrice;

  @Before
  public void setUp() {
    threshold = 10;
    reducedPrice = 800;
    cart = new ShoppingCart();
    product = new Product("something", 1000);
  }

  @Test
  public void belowThresholdAskBasePrice() {
    int quantity = threshold - 1;
    CartItem degressiveItem = new DegressiveItem(product, quantity, threshold, reducedPrice);
    cart.add(degressiveItem);
    assertEquals(quantity * degressiveItem.unitPrice(), cart.total(), 0.0);
  }

  @Test
  public void overThresholdAskReducedPrice() {
    int quantity = threshold * 2;
    CartItem degressiveItem = new DegressiveItem(product, quantity, threshold, reducedPrice);
    cart.add(degressiveItem);
    assertEquals(quantity * reducedPrice, cart.total(), 0.0);
  }

  @Test
  public void atThresholdAskReducedPrice() {
    int quantity = threshold;
    CartItem degressiveItem = new DegressiveItem(product, quantity, threshold, reducedPrice);
    cart.add(degressiveItem);
    assertEquals(quantity * reducedPrice, cart.total(), 0.0);
  }
}