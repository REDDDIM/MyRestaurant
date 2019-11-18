package entities;

import lombok.*;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table (name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_delivery")
    private Long id;
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @Column(name = "time_of_delivery")
    private Time timeOfDelivery;
    @Column(name = "cost_of_delivery")
    private double costOfDelivery;

    public Delivery convertToDto() {
        DateFormat dateFormat = new SimpleDateFormat(" День: dd Месяц: MM Год: yyyy \nВремя: hh:mm:ss");
        String data = deliveryDate.get(Calendar.DATE) + "." + deliveryDate.get(Calendar.MONTH) + "." + deliveryDate.get(Calendar.YEAR);
        String time = timeOfDelivery.get(Calendar.HOUR) + ":" + timeOfDelivery.get(Calendar.MINUTE)  + ":" +  timeOfDelivery.get(Calendar.SECOND);
        return new Delivery(id, deliveryDate, timeOfDelivery, costOfDelivery);
    }
}
