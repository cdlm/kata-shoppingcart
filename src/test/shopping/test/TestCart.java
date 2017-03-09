package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.CartItem;
import shopping.core.Product;
import shopping.core.RegularItem;
import shopping.core.ShoppingCart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCart {

  private ShoppingCart cart;
  private Product pizza, sauce, pasta;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    pizza = new Product("pizza", 650);
    sauce = new Product("tomate basilic", 350);
    pasta = new Product("spaghetti", 250);
  }


  @Test
  public void emptyCartCostsZero() {
    assertEquals(0, cart.total());
  }


  @Test
  public void addClear() {
    cart.add(new RegularItem(pizza, 1));
    cart.add(new RegularItem(sauce, 2));
    cart.clear();
    assertEquals(0, cart.total());
  }

  @Test
  public void addRemove() {
    CartItem item1 = new RegularItem(pizza, 3);
    CartItem item2 = new RegularItem(pasta, 1);
    cart.clear();
    cart.add(item1);
    cart.add(item2);
    cart.remove(item1);
    assertEquals(250, cart.total());
  }


  @Test
  public void quantityProduct() {
    int qty1 = 3;
    int qty2 = 5;
    CartItem item1 = new RegularItem(pizza, qty1);
    CartItem item2 = new RegularItem(pizza, qty2);
    cart.clear();
    cart.add(item1);
    cart.add(item2);
    assertEquals(qty1 + qty2, cart.quantity(pizza));
  }

  @Test
  public void priceGreater() {
    int qty = 10;
    CartItem item1 = new RegularItem(pizza, qty);
    CartItem item2 = new RegularItem(pasta, qty);
    cart.clear();
    cart.add(item1);
    cart.add(item2);
    assertTrue(cart.priceGreater(6000).contains(item1));
  }

  @Test
  public void printEmpty() {
    assertTrue("Cart printout should end with correct total",
               cart.toString().endsWith("TOTAL:\t    0.00"));
  }

  @Test
  public void printOneOfEach() {
    cart.add(new RegularItem(sauce, 1));
    cart.add(new RegularItem(pizza, 1));
    cart.add(new RegularItem(pasta, 1));
    String printout = cart.toString();
    assertTrue("Cart printout should end with correct total",
               printout.endsWith("TOTAL:\t   12.50"));
    assertTrue("Cart printout should have at least one line per item (then the total)",
               printout.split("\n").length >= 4);
  }
}
