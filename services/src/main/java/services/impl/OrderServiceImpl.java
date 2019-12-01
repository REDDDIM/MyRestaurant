package services.impl;

import dao.repository.OrderRepository;
import dao.repository.OrderTypeRepository;
import dao.repository.UserRepository;
import entities.Order;
import entities.OrderType;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.OrderService;

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


    @Override
    public List<Order> getOrdersForUser(Long userId) {
        return orderRepository.getByUserId(userId);
    }

    @Override
    public void createOrder(Long userId, String orderType, String resultPayment, String menu, String address, String phoneNumber) {
        Order order = new Order();
        User user = userRepository.getOne(new Long(userId));
        order.setUser(user);
        order.setOrderType(orderTypeRepository.getByName(orderType));
        order.setAddress(address);
        order.setOrderDate(new Date());
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);
    }
}
