package shopping.core;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> quantities;

    public Cart() {
        quantities = new LinkedHashMap<Item, Integer>();
    }

    public int total() {
        int result = 0;
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
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

    @Override
    public String toString() {
        String line = "--------------------------------\n";
        StringBuffer sb = new StringBuffer();
        sb.append(line);
        for (Item each : quantities.keySet()) {
            sb.append(String.format("%-24s % 7.2f\n", each.description(), each.unitPrice() / 100.0));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", total() / 100.0));
        return sb.toString();
    }
}
