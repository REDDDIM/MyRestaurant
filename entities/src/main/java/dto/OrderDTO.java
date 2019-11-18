package dto;

import entities.Order;
import entities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderDTO {
    private Long id;
    private User user;
    private String orderType;
    private GregorianCalendar orderDate;

    @Override
    public String toString() {
        return "OrderDTO{"
                + "id="
                + id
                + ", user="
                + user.getName()
                + " "
                + user.getSurname()
                + " "
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

    public Order convertToEntity() throws ParseException {
        return new Order(id, user, orderType, orderDate);
    }

    public String getOrderDateString() {
        return orderDate.get(Calendar.DATE)
                + "."
                + (orderDate.get(Calendar.MONTH) + 1)
                + "."
                + orderDate.get(Calendar.YEAR)
                + " "
                + orderDate.get(Calendar.HOUR_OF_DAY)
                + ":"
                + orderDate.get(Calendar.MINUTE)
                + ":"
                + orderDate.get(Calendar.SECOND);
    }
}
