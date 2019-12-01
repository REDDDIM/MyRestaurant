package services.impl;

import dao.repository.OrderRepository;
import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersForUser(Long userId) {
        return orderRepository.getByUserId(userId);
    }
}
