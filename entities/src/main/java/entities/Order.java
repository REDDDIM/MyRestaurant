package entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_order")
    private Long id;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_user")
    private User user;
    @Column (name = "order_type")
    private String orderType;
    @Column (name = "order_date")
    private GregorianCalendar orderDate;

    @Override
    public String toString() {
        return "Order{"
                + "id="
                + id
                + ", user="
                + user
                + ", orderType='"
                + orderType
                + '\''
                + ", orderDate="
                + orderDate.get(Calendar.DATE)
                + "."
                + orderDate.get(Calendar.MONTH)
                + "."
                + orderDate.get(Calendar.YEAR)
                + "."
                + orderDate.get(Calendar.HOUR_OF_DAY)
                + ":"
                + orderDate.get(Calendar.MINUTE)
                + ":"
                + orderDate.get(Calendar.SECOND)
                + '}';
    }

    public Order convertToDto() {
        return new Order(id, user.convertToDto(), orderType, orderDate);
    }
}
