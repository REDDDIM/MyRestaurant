package services.impl;

import dao.repository.OrderRepository;
import dao.repository.OrderTypeRepository;
import dao.repository.UserRepository;
import dto.OrderDto;
import entities.*;
import enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.OrderService;
import services.converter.BaseConverter;
import services.exceptions.OrderException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    @Qualifier("orderConverter")
    private BaseConverter<OrderDto, Order> converter;

    @Override
    public List<OrderDto> getOrdersForUser(Long userId) throws OrderException {
        List<Order> entities = orderRepository.getByUserId(userId);
        if (entities.isEmpty()) throw new OrderException("Список заказов пуст!");
        return entities
                .stream().map(e -> converter.convertToDto(e)).
                        collect(Collectors.toList());
    }

    @Override
    public Order createOrder(OrderDto order){
        Order orderEntity = converter.convertToEntity(order);
        orderEntity.setUser(userRepository.findByLogin(order.getUser().getLogin()));
        orderEntity.setOrderStatus(OrderStatusEnum.NEW);
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
        order.setOrderStatus(OrderStatusEnum.valueOf(newStatusName.toUpperCase()));
        orderRepository.save(order);
    }

    @Override
    public void setOrderToCourier(Long courierId, Long orderId) {
        Order order = orderRepository.getOne(orderId);
        User courier = userRepository.getOne(courierId);
        order.setOrderStatus(OrderStatusEnum.TRANSFERRED_TO_THE_COURIER);
        order.setCourier(courier);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getCourierOrders(Long courierId) throws OrderException {
        List<Order> entities = orderRepository.getCourierOrders(courierId);
        if (entities.isEmpty()) throw new OrderException("Список заказов пуст!");
        return entities.
                stream().map(e -> converter.convertToDto(e)).
                collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        orderRepository.delete(id);
    }

}
