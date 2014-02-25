package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.pricing.BundlePricing;
import shopping.core.Cart;
import shopping.core.Item;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

public class TestCart {

    private Cart cart;
    private Item pizza, sauce, pasta;

    @Before
    public void setUp() {
        cart = new Cart();
        pizza = new Product("pizza", 650);
        sauce = new Product("tomate basilic", 350);
        pasta = new BundlePricing(new Product("spaghetti", 250), 3, 2);
    }

    @Test
    public void test_printEmpty() {
        assertEquals("--------------------------------\n" +
                "--------------------------------\n" +
                "                  TOTAL:    0.00", cart.toString());
    }

    @Test
    public void test_printOneOfEach() {
        cart.add(sauce);
        cart.add(pizza);
        cart.add(pasta);
        assertEquals("--------------------------------\n" +
                "tomate basilic              3.50\n" +
                "pizza                       6.50\n" +
                "spaghetti                   2.50\n" +
                "--------------------------------\n" +
                "                  TOTAL:   12.50", cart.toString());
    }
}
