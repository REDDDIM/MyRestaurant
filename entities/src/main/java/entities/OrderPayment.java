package entities;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "order_payment")
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_order_payment")
    private Long id;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_order")
    private Order order;
    @Column (name = "total_amount")
    private double totalAmount;
    @Column (name = "cash")
    private double cash;
    @Column (name = "lease")
    private double lease;

    public OrderPayment convertToDto() {
        return new OrderPayment(id, order.convertToDto(), totalAmount, cash, lease);
    }
}
