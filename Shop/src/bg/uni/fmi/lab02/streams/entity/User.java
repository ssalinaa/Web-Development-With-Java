package bg.uni.fmi.lab02.streams.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Order> orders;

    public User(List<Order> orders) {
        this.orders = orders;
    }

    public User() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "User{\n orders=" + orders + '}';
    }
}
