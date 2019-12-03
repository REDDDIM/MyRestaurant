package services;

import entities.Order;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(Long userId);

    Order createOrder(String order) throws IOException;

    List<Order> getAll();

    void changeOrderStatus(Long orderId, String newStatusName);

    void setOrderToCourier(Long courierId, Long orderId);
}
