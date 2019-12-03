package services;

import entities.Order;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(Long userId);

    Order createOrder(String order) throws IOException;

    List<Order> getAll();
}
