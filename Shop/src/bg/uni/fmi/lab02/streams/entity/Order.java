package bg.uni.fmi.lab02.streams.entity;

import bg.uni.fmi.lab02.streams.vo.OrderStatus;
import bg.uni.fmi.lab02.streams.vo.PaymentMethod;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private long id;
    private List<OrderLine> orderLines;
    private LocalDate orderDate;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private LocalDate deliveryDueDate;
    private User user;

    public Order(long id, List<OrderLine> orderLines, OrderStatus status, LocalDate orderDate, PaymentMethod paymentMethod, LocalDate deliveryDueDate, User user) {
        this.id = id;
        this.orderLines = orderLines;
        this.status = status;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.deliveryDueDate = deliveryDueDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public User getUser() {
        return user;
    }

    public boolean isActive() {
        return this.status == OrderStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Order{\n id=" + id + ",\n orderLines=" + orderLines + ",\n orderDate=" + orderDate + ",\n status=" + status + ",\n paymentMethod=" + paymentMethod + ",\n deliveryDueDate=" + deliveryDueDate + ",\n user=" + user + '}';
    }
}
