package interfaces;

import entities.OrderPayment;
import java.util.List;

public interface OrderPaymentService {
    List<OrderPayment> getAllOrderPayments();
    OrderPayment getOrderPaymentByID(Long id);
    void createOrderPayment(OrderPayment orderPayment) throws Exception;
    void updateOrderPayment(OrderPayment orderPayment);
    void deleteOrderPayment(OrderPayment orderPayment);
}
