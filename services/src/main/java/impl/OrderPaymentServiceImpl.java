package impl;

import dao.repository.OrderPaymentRepository;
import entities.OrderPayment;
import interfaces.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {
    @Autowired
    private OrderPaymentRepository orderPaymentRepository;

    @Override
    public List<OrderPayment> getAllOrderPayments() {
        return orderPaymentRepository.findAll();
    }

    @Override
    public OrderPayment getOrderPaymentByID(Long id) {
        return orderPaymentRepository.findOne(id);
    }

    @Override
    public void createOrderPayment(OrderPayment orderPayment) throws Exception {
        orderPaymentRepository.saveAndFlush(orderPayment);
    }

    @Override
    public void updateOrderPayment(OrderPayment orderPayment) {
        orderPaymentRepository.saveAndFlush(orderPayment);
    }

    @Override
    public void deleteOrderPayment(OrderPayment orderPayment) {
        orderPaymentRepository.delete(orderPayment);
    }
}
