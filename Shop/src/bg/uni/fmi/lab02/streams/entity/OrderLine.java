package bg.uni.fmi.lab02.streams.entity;

public class OrderLine {
    private Item item;
    private int quantity;
    private boolean specialOffer;

    public OrderLine(Item item, int quantity, boolean specialOffer) {
        this.item = item;
        this.quantity = quantity;
        this.specialOffer = specialOffer;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean specialOffer() {
        return specialOffer;
    }

    @Override
    public String toString() {
        return "OrderLine{\n item=" + item + ",\n quantity=" + quantity + ",\n specialOffer=" + specialOffer + '}';
    }
}
