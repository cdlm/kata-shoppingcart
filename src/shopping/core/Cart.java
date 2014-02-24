package shopping.core;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> quantities;

    public Cart() {
        quantities = new HashMap<Item, Integer>();
    }

    public int total() {
        int result = 0;
        for (Item each : quantities.keySet()) {
            result += result + each.priceForQuantity(quantities.get(each));
        }
        return result;
    }

    public void add(Item itemToBuy) {
        add(itemToBuy, 1);
    }

    public void add(Item itemToBuy, int howMany) {
        int previousQuantity = quantities.containsKey(itemToBuy)
                ? quantities.get(itemToBuy)
                : 0;
        quantities.put(itemToBuy, previousQuantity + howMany);
    }
}
