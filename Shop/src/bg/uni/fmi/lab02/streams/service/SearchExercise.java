package bg.uni.fmi.lab02.streams.service;

import bg.uni.fmi.lab02.streams.entity.Order;
import bg.uni.fmi.lab02.streams.entity.User;
import bg.uni.fmi.lab02.streams.entity.OrderLine;
import bg.uni.fmi.lab02.streams.vo.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchExercise {
    public List<Order> getActiveOrders(User user) {
       return user.getOrders().stream()
               .filter(order -> order.getStatus() == OrderStatus.ACTIVE)
               .collect(Collectors.toList());
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        List<Order> activeOrders = new ArrayList<>();
        for(Order order : user.getOrders()) {
            if(order.getStatus() == OrderStatus.ACTIVE) {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    public Order getOrderById(List<Order> orders, long orderId) {
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        for(Order order : orders) {
            if(order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        return user.getOrders().stream()
                .filter(order -> order.getOrderLines().stream()
                        .anyMatch(line -> line.getItem().getDescription().equals(description)))
                .collect(Collectors.toList());
    }

    public boolean hasActiveOrders(User user) {
        return user.getOrders().stream()
                .anyMatch(order -> order.getStatus() == OrderStatus.ACTIVE);
    }

    public boolean canBeReturned(Order order) {
        return order.getOrderLines().stream()
                .noneMatch(OrderLine::specialOffer);
    }

    public Optional<Order> getMaxPriceOrder(User user) {
        return user.getOrders().stream()
                .max((p1, p2) -> Double.compare(
                        p1.getOrderLines().stream().mapToDouble(line -> line.getItem().getPrice().doubleValue()).sum(),
                        p2.getOrderLines().stream().mapToDouble(line -> line.getItem().getPrice().doubleValue()).sum()
                ));
    }
}
