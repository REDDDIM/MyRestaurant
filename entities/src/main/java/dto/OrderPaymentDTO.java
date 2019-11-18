package dto;

import entities.Order;
import entities.OrderPayment;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderPaymentDTO {
    private Long id;
    private Order order;
    private double totalAmount;
    private double cash;
    private double lease;

    @Override
    public String toString() {
        return "OrderPaymentDTO{" +
                "id=" + id +
                ", order=" + order +
                ", totalAmount=" + totalAmount +
                ", cash=" + cash +
                ", lease=" + lease +
                '}';
    }

    public OrderPayment convertToEntity() {
        return new OrderPayment(id, order, totalAmount, cash, lease);
    }
}
