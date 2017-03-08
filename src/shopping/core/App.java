package shopping.core;

public class App {

  public static void main(String[] args) {
    Product bier = new Product("Bier", 3);
    Product pizza = new Product("Pizza", 6);

    Cart cart = new Cart();
    CartItem item1 = new RegularItem(bier, 6);
    CartItem item2 = new BundledItem(pizza, 5, 2, 4);
    cart.add(item1);
    cart.add(item2);

    System.out.println(cart);

    item1.increaseQty(3);

    System.out.println(cart);

  }

}
