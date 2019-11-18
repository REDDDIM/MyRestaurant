package dto;

import entities.Delivery;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
    private double costOfDelivery;

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "id=" + id +
                ", idOrder=" + idOrder +
                ", deliveryDate=" + deliveryDate +
                ", timeOfDelivery=" + timeOfDelivery +
                ", costOfDelivery=" + costOfDelivery +
                '}';
    }

    public Delivery convertToEntity() {
        return new Delivery(id, deliveryDate, timeOfDelivery, costOfDelivery);
    }
}
