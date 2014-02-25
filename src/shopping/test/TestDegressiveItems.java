package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Cart;
import shopping.core.DegressivePricing;
import shopping.core.Item;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

public class TestDegressiveItems {

    private Cart cart;
    private Item item;
    private Item degressiveItem;
    private int threshold;
    private int reducedPrice;

    @Before
    public void setUp() {
        threshold = 10;
        reducedPrice = 800;
        cart = new Cart();
        item = new Product("something", 1000);
        degressiveItem = new DegressivePricing(item, threshold, reducedPrice);
    }

    @Test
    public void test_belowThresholdAskBasePrice() {
        int quantity = threshold - 1;
        cart.add(degressiveItem, quantity);
        assertEquals(quantity * item.unitPrice(), cart.total());
    }

    @Test
    public void test_overThresholdAskReducedPrice() {
        int quantity = threshold * 2;
        cart.add(degressiveItem, quantity);
        assertEquals(quantity * reducedPrice, cart.total());
    }

    @Test
    public void test_atThresholdAskReducedPrice() {
        int quantity = threshold;
        cart.add(degressiveItem, quantity);
        assertEquals(quantity * reducedPrice, cart.total());
    }
}
