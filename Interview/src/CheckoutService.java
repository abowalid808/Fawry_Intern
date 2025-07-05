import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        double subtotal = 0.0;
        double shipping = 0.0;
        List<Shippable> shippingItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();

            if (p instanceof ExpiredProduct exp && exp.isExpired())
                throw new IllegalStateException(p.getName() + " is expired.");
            if (qty > p.getQuantity())
                throw new IllegalStateException(p.getName() + " is out of stock.");

            subtotal += p.getPrice() * qty;

            if (p.isShiped()) {
                for (int i = 0; i < qty; i++)
                    shippingItems.add((Shippable) p);
                shipping += ((Shippable) p).getWeight() * 10;
            }
        }

        double total = subtotal + shipping;
        if (customer.getBalance() < total)
            throw new IllegalStateException("Insufficient balance.");

        customer.deduct(total);

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        if (!shippingItems.isEmpty()) {
            ShippingService.ship(shippingItems);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName());
            System.out.println((entry.getKey().getPrice() * entry.getValue()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal:        " + subtotal);
        System.out.println("Shipping:        " + shipping);
        System.out.println("Amount:          " + total);
        System.out.println("Balance left:    " + customer.getBalance());

        cart.clear();
    }
}
