package shopping.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import shopping.core.Cart;
import shopping.core.CartItem;
import shopping.core.Product;
import shopping.core.RegularItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCart {

    private Cart cart;
    private Product pizza, sauce, pasta;

    @Before
    public void setUp() {
        cart = new Cart();
        pizza = new Product("pizza", 6.50);
        sauce = new Product("tomate basilic", 3.50);
        pasta = new Product("spaghetti", 2.50);
    }

    
    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0.0, cart.total(),0.0);
    }

    
    @Test
    public void test_addClear() {
    	cart.add(new RegularItem(pizza, 1));
    	cart.add(new RegularItem(sauce, 2));
    	cart.clear();
    	assertEquals(0.0, cart.total(),0.0);
    }
    
    @Test
    public void test_addRemove() {
    	CartItem item1 = new RegularItem(pizza, 3);
    	CartItem item2 = new RegularItem(pasta, 1);
    	cart.clear();
    	cart.add(item1);
    	cart.add(item2);
    	cart.remove(item1);
    	assertEquals(pasta.unitPrice(), cart.total(),0.0);    	
    }
    
    
    @Test
    public void test_quantityProduct() {
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
    public void test_priceGreater() {
    	int qty = 10;
    	CartItem item1 = new RegularItem(pizza, qty);
    	CartItem item2 = new RegularItem(pasta, qty);  	
    	cart.clear();
    	cart.add(item1);
    	cart.add(item2);
    	assertTrue(cart.priceGreater(60.0).contains(item1));
    }
    
    @Test
    public void test_printEmpty() {
        assertEquals("--------------------------------\n" +
                "--------------------------------\n" +
                "                  TOTAL:\t    0.00", cart.toString());
    }

  @Test
    public void test_printOneOfEach() {
        cart.add(new RegularItem(sauce, 1));
        cart.add(new RegularItem(pizza, 1));
        cart.add(new RegularItem(pasta, 1));
        assertEquals("--------------------------------\n" +
        		"Regular Item(tomate basilic,1,3.5)\t    3.50\n" + 
        		"Regular Item(pizza,1,6.5)\t    6.50\n" + 
        		"Regular Item(spaghetti,1,2.5)\t    2.50\n" + 
                "--------------------------------\n" +
                "                  TOTAL:\t   12.50", cart.toString());
    } 
}
