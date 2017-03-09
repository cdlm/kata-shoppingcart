package shopping.test;

import org.junit.Before;
import org.junit.Test;

import shopping.core.BundledItem;
import shopping.core.ShoppingCart;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

public class TestBundledItems {

  private ShoppingCart cart;
  private Product product;
  private int bundleQuantity;
  private int paidQuantity;

  @Before
  public void setUp() {
    bundleQuantity = 3;
    paidQuantity = 2;
    cart = new ShoppingCart();
    product = new Product("something", 1000);
  }

  @Test
  public void buyThatManyGetSomeFree() {
    cart.clear();
    BundledItem
        bundledItem =
        new BundledItem(product, bundleQuantity, bundleQuantity, paidQuantity);
    cart.add(bundledItem);
    assertEquals(paidQuantity * bundledItem.unitPrice(), cart.total(), 0.0);
  }

  @Test
  public void multipleBundles() {
    int howManyBundles = 5;
    BundledItem
        bundledItem =
        new BundledItem(product, bundleQuantity * howManyBundles, bundleQuantity, paidQuantity);
    cart.clear();
    cart.add(bundledItem);
    assertEquals(howManyBundles * paidQuantity * bundledItem.unitPrice(), cart.total(), 0.0);
  }

  @Test
  public void belowBundleGetNormalPrice() {
    int howMany = bundleQuantity - 1;
    BundledItem bundledItem = new BundledItem(product, howMany, bundleQuantity, paidQuantity);
    cart.clear();
    cart.add(bundledItem);
    assertEquals(howMany * bundledItem.unitPrice(), cart.total(), 0.0);
  }

  @Test
  public void incompleteBundleGetNormalPrice() {
    int bundlesPlusOne = 5 * bundleQuantity + 1;
    BundledItem
        bundledItem =
        new BundledItem(product, bundlesPlusOne, bundleQuantity, paidQuantity);
    cart.clear();
    cart.add(bundledItem);
    assertEquals((5 * paidQuantity + 1) * bundledItem.unitPrice(), cart.total(), 0.0);
  }
}
