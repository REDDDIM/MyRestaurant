package entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "order_payment")
public class OrderPayment extends BaseEntity {

    private Order order;
    @Column (name = "total_amount")
    private BigDecimal totalAmount;
    @Column (name = "cash")
    private BigDecimal cash;
    @Column (name = "lease")
    private BigDecimal lease;

    @Column (name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getLease() {
        return lease;
    }

    public void setLease(BigDecimal lease) {
        this.lease = lease;
    }
}
