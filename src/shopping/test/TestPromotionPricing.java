package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Cart;
import shopping.core.Item;
import shopping.core.Product;
import shopping.pricing.PromotionPricing;

import static org.junit.Assert.assertEquals;

public class TestPromotionPricing {

    private Cart cart;
    private Item item;
    private Item degressiveItem;

    @Before
    public void setUp() {
        cart = new Cart();
        item = new Product("something", 1000);
    }

    @Test
    public void test_promotionAppliesToOne() {
        degressiveItem = new PromotionPricing(item, 15);
        cart.add(degressiveItem);
        assertEquals(850, cart.total());
    }
}
