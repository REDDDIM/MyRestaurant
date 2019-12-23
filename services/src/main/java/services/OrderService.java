package services;

import dto.OrderDto;
import entities.Order;
import services.exceptions.OrderException;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    List<OrderDto> getOrdersForUser(Long userId) throws OrderException;

    Order createOrder(OrderDto order) throws OrderException;

    List<OrderDto> getAll() throws OrderException;

    void changeOrderStatus(Long orderId, String newStatusName);

    void setOrderToCourier(Long courierId, Long orderId);

    List<OrderDto> getCourierOrders(Long courierId) throws OrderException;

    void remove(Long id);
}
