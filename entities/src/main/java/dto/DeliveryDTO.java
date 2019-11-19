package dto;

import entities.Delivery;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DeliveryDTO {
    private Long id;
    private Long idOrder;
    private Date deliveryDate;
    private Time timeOfDelivery;
    private BigDecimal costOfDelivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
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
