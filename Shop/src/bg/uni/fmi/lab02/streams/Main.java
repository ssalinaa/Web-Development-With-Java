package bg.uni.fmi.lab02.streams;

import java.util.*;

import bg.uni.fmi.lab02.streams.entity.Order;
import bg.uni.fmi.lab02.streams.entity.User;
import bg.uni.fmi.lab02.streams.entity.Item;
import bg.uni.fmi.lab02.streams.entity.OrderLine;
import bg.uni.fmi.lab02.streams.vo.OrderStatus;
import bg.uni.fmi.lab02.streams.vo.PaymentMethod;
import bg.uni.fmi.lab02.streams.service.SearchExercise;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Създаване на примери за продукти
        Item item1 = new Item("Laptop", "High-performance laptop", new BigDecimal("1200.00"));
        Item item2 = new Item("Headphones", "Noise-cancelling headphones", new BigDecimal("200.00"));

        // Създаване на примерни OrderLine (поръчкови линии)
        OrderLine orderLine1 = new OrderLine(item1, 1, true);  // Продукт със специално предложение
        OrderLine orderLine2 = new OrderLine(item2, 2, false); // Продукт без специално предложение

        // Създаване на поръчки
        Order order1 = new Order(1, Arrays.asList(orderLine1, orderLine2), OrderStatus.ACTIVE, LocalDate.now(), PaymentMethod.CARD, LocalDate.now().plusDays(7), null);
        Order order2 = new Order(2, Arrays.asList(orderLine2), OrderStatus.DRAFT, LocalDate.now(), PaymentMethod.CASH_ON_SITE, LocalDate.now().plusDays(5), null);

        // Създаване на потребител и добавяне на поръчки
        User user = new User();
        user.addOrder(order1);
        user.addOrder(order2);

        // Създаване на SearchExercise за изпълнение на бизнес логиката
        SearchExercise searchExercise = new SearchExercise();

        // Извличане на всички активни поръчки
        List<Order> activeOrders = searchExercise.getActiveOrders(user);
        System.out.println("Active Orders: " + activeOrders);

        // Извличане на поръчки, които имат конкретно описание на продукт
        String description = "Noise-cancelling headphones";
        List<Order> ordersWithSpecificDescription = searchExercise.getOrdersThatHaveItemDescription(user, description);
        System.out.println("Orders with specific description: " + ordersWithSpecificDescription);

        // Проверка дали има поне една активна поръчка
        boolean hasActive = searchExercise.hasActiveOrders(user);
        System.out.println("Has Active Orders: " + hasActive);

        // Намиране на поръчка с максимална стойност
        Optional<Order> maxPriceOrder = searchExercise.getMaxPriceOrder(user);
        maxPriceOrder.ifPresent(order -> System.out.println("Max Price Order: " + order));
    }
}
