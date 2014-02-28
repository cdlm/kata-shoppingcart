package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Product;
import shopping.core.Cart;
import shopping.core.CartItem;
import shopping.core.RegularItem;

import static org.junit.Assert.assertEquals;

public class TestBasicItems {

    private Cart cart;
    private Product product;
    private CartItem item;

    @Before
    public void setUp() {
        cart = new Cart();
        product = new Product("Cheese", 3);
        item = new RegularItem(product, 2);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.total());
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.add(item);
        assertEquals(item.unitPrice() * item.getQuantity(), cart.total());
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
