package entities;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table (name = "delivery")
public class Delivery extends BaseEntity {


    private List<Order> order;
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @Column(name = "time_of_delivery")
    private Time timeOfDelivery;
    @Column(name = "cost_of_delivery")
    private BigDecimal costOfDelivery;

    @OneToMany
    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Time getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setTimeOfDelivery(Time timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public BigDecimal getCostOfDelivery() {
        return costOfDelivery;
    }

    public void setCostOfDelivery(BigDecimal costOfDelivery) {
        this.costOfDelivery = costOfDelivery;
    }

}
