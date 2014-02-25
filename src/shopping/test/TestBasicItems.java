package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Product;
import shopping.core.Cart;
import shopping.core.Item;

import static org.junit.Assert.assertEquals;

public class TestBasicItems {

    private Cart cart;
    private Item item;

    @Before
    public void setUp() {
        cart = new Cart();
        item = new Product("something", 1000);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.total());
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.add(item);
        assertEquals(item.unitPrice(), cart.total());
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        cart.add(item, howMany);
        assertEquals(howMany * item.unitPrice(), cart.total());
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            cart.add(item);
        }
        assertEquals(howMany * item.unitPrice(), cart.total());
    }
}
