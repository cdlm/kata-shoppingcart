package shopping.core;

import java.util.LinkedList;
import java.util.List;

public class Cart {
    protected List<CartItem> items;

    public Cart() {
        items = new LinkedList<CartItem>();
    }

    public int total() {
        int result = 0;
        for (CartItem each : items) {
            result += each.totalPrice();
        }
        return result;
    }

    public void add(CartItem item) {
    	items.add(item);
    }
    
    public void remove(CartItem item) {
    	items.remove(item);
    }
    
    public int quantityForProduct(Product product) {
    	for (CartItem item : items) {
    		if (item.getProduct().equals(product)) {
    			return item.getQuantity();
    		}
    	}
    	return 0;
    }

    @Override
    public String toString() {
        String line = "--------------------------------\n";
        StringBuffer sb = new StringBuffer();
        sb.append(line);
        for (CartItem each : items) {
            sb.append(String.format("%-24s %d\n", each.description(), each.totalPrice()));
           
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", total() / 100.0));
        return sb.toString();
    }
}
