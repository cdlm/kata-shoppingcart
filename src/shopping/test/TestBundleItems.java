package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.BundlePricing;
import shopping.core.Cart;
import shopping.core.Item;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

public class TestBundleItems {

    private Cart cart;
    private Item item;
    private Item bundleItem;
    private int bundleQuantity;
    private int paidQuantity;

    @Before
    public void setUp() {
        bundleQuantity = 3;
        paidQuantity = 2;
        cart = new Cart();
        item = new Product("something", 1000);
        bundleItem = new BundlePricing(item, bundleQuantity, paidQuantity);
    }

    @Test
    public void test_buyThatManyGetSomeFree() {
        cart.add(bundleItem, bundleQuantity);
        assertEquals(paidQuantity * item.unitPrice(), cart.total());
    }

    @Test
    public void test_multipleBundles() {
        int howManyBundles = 5;
        cart.add(bundleItem, howManyBundles * bundleQuantity);
        assertEquals(howManyBundles * paidQuantity * item.unitPrice(), cart.total());
    }

    @Test
    public void test_belowBundleGetNormalPrice() {
        int howMany = bundleQuantity - 1;
        cart.add(bundleItem, howMany);
        assertEquals(howMany * item.unitPrice(), cart.total());
    }

    @Test
    public void test_incompleteBundleGetNormalPrice() {
        int oneOverFiveBundles = 5 * bundleQuantity + 1;
        cart.add(bundleItem, oneOverFiveBundles);
        assertEquals((5 * paidQuantity + 1) * item.unitPrice(), cart.total());
    }
}
