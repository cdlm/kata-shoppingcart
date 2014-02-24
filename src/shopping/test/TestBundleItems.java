package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.BundlePricedItem;
import shopping.core.Cart;
import shopping.core.Item;

import static org.junit.Assert.assertEquals;

public class TestBundleItems {

    private Cart cart;
    private Item item;
    private int bundleQuantity;
    private int paidQuantity;

    @Before
    public void setUp() {
        bundleQuantity = 3;
        paidQuantity = 2;
        cart = new Cart();
        item = new BundlePricedItem("something", 1000, bundleQuantity, paidQuantity);

    }

    @Test
    public void test_buyThatManyGetSomeFree() {
        cart.add(item, bundleQuantity);
        assertEquals(paidQuantity * item.unitPrice(), cart.total());
    }

    @Test
    public void test_multipleBundles() {
        int bundles = 5;
        cart.add(item, 5 * bundleQuantity);
        assertEquals(5 * paidQuantity * item.unitPrice(), cart.total());
    }

    @Test
    public void test_belowBundleGetNormalPrice() {
        cart.add(item, bundleQuantity - 1);
        assertEquals((bundleQuantity - 1) * item.unitPrice(), cart.total());
    }

    @Test
    public void test_incompleteBundleGetNormalPrice() {
        int oneOverFiveBundles = 5 * bundleQuantity + 1;
        cart.add(item, oneOverFiveBundles);
        assertEquals((5 * paidQuantity + 1) * item.unitPrice(), cart.total());
    }
}
