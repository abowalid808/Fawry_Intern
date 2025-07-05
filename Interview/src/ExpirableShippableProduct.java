public class ExpirableShippableProduct extends ExpiredProduct implements Shippable {
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired);
        this.weight = weight;
    }

    @Override
    public boolean isShiped() { return true; }

    @Override
    public double getWeight() { return weight; }

    @Override
    public String getName() { return name; }
}
