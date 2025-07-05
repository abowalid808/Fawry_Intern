public class Main {
    public static void main(String[] args) {
        System.out.println("\n------ Example ------");
        example();
    }

    public static void example() {
        Customer bob = new Customer("Bob", 600);

        Product tv = new ShippableProduct("TV", 350, 2, 8.0);
        Product expiredCheese = new ExpirableShippableProduct("Cheese", 90, 5, true, 0.5);
        Product scratchCard = new DigitalProduct("Scratch Card", 30, 100);

        Cart cart = new Cart();
        try {
            cart.add(tv, 1);
            cart.add(scratchCard, 2);

            CheckoutService.checkout(bob, cart);
        } catch (Exception e) {
            System.out.println("Retry checkout failed: " + e.getMessage());
        }
    }
}
