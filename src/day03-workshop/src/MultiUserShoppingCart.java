/**
 * App
 */

public class MultiUserShoppingCart {

    public static void main(String[] args) {

        ShoppingCartDB cart = new ShoppingCartDB("cartdb"); // default db
        // cart.setup(); // check if it exists, if it isnt then create
        cart.startShell();
    }
}