package services;

import entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(Long userId);

    void createOrder(Long userId,
                     String orderType,
                     String resultPayment,
                     String menu,
                     String address,
                     String phoneNumber);
}
