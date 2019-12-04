package services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.repository.OrderRepository;
import dao.repository.OrderStatusRepository;
import dao.repository.OrderTypeRepository;
import dao.repository.UserRepository;
import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.OrderService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Override
    public List<Order> getOrdersForUser(Long userId) {
        return orderRepository.getByUserId(userId);
    }

    @Override
    public Order createOrder(String order) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Order order1 = mapper.readValue(order, Order.class);
        order1.setUser(userRepository.findByLogin(order1.getUser().getLogin()));
        order1.setOrderStatus(orderStatusRepository.getByName("new"));
        order1.setOrderType(orderTypeRepository.getByName(order1.getOrderType().getName()));
        return orderRepository.save(order1);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void changeOrderStatus(Long orderId, String newStatusName) {
        Order order = orderRepository.getOne(orderId);
        OrderStatus status = orderStatusRepository.getByName(newStatusName);
        order.setOrderStatus(status);
        orderRepository.save(order);
    }

    @Override
    public void setOrderToCourier(Long courierId, Long orderId) {
        Order order = orderRepository.getOne(orderId);
        OrderStatus newOrderStatus = orderStatusRepository.getByName("transferred_to_the_courier");
        User courier = userRepository.getOne(courierId);
        order.setOrderStatus(newOrderStatus);
        order.setCourier(courier);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getCourierOrders(Long courierId) {
        return orderRepository.getCourierOrders(courierId);
    }


}
