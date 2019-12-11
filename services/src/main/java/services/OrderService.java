package services;

import dto.OrderDto;
import entities.Order;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    List<OrderDto> getOrdersForUser(Long userId);

    Order createOrder(OrderDto order);

    List<OrderDto> getAll();

    void changeOrderStatus(Long orderId, String newStatusName);

    void setOrderToCourier(Long courierId, Long orderId);

    List<OrderDto> getCourierOrders(Long courierId);

    void remove(Long id);
}
