import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println(item.getName() + "\n" + (item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
