package services.impl;

import dao.repository.OrderRepository;
import dao.repository.OrderStatusRepository;
import dao.repository.OrderTypeRepository;
import dao.repository.UserRepository;
import dto.OrderDto;
import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.OrderService;
import services.converter.BaseConverter;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    @Qualifier("orderConverter")
    BaseConverter<OrderDto, Order> converter;

    @Override
    public List<OrderDto> getOrdersForUser(Long userId) {
        return orderRepository.getByUserId(userId)
                .stream().map(e -> converter.convertToDto(e)).
                        collect(Collectors.toList());
    }

    @Override
    public Order createOrder(OrderDto order){
        Order orderEntity = converter.convertToEntity(order);
        orderEntity.setUser(userRepository.findByLogin(order.getUser().getLogin()));
        orderEntity.setOrderStatus(orderStatusRepository.getByName("new"));
        orderEntity.setOrderType(orderTypeRepository.getByName(order.getOrderType().getName()));
        return orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll().
                stream().map(e -> converter.convertToDto(e)).
                collect(Collectors.toList());
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
    public List<OrderDto> getCourierOrders(Long courierId) {
        return orderRepository.getCourierOrders(courierId).
                stream().map(e -> converter.convertToDto(e)).
                collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        orderRepository.delete(id);
    }


}
