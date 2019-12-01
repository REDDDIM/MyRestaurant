package services;

import entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(Long userId);
}
