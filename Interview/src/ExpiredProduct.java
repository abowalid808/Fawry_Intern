public class ExpiredProduct extends Product{
    private boolean expired;

    public ExpiredProduct(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity);
        this.expired = expired;
    }

    @Override
    public boolean isExpired() { return true; }

    public boolean isExpirable() { return expired; }
}
