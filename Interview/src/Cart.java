import java.util.*;
public class Cart {
    private Map<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0 || quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
