package dto;

import entities.Menu;
import entities.Order;
import entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderItemDTO {
    private Menu menu;
    private Order order;
    private int numberOfServings;

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "menu=" + menu +
                ", order=" + order +
                ", numberOfServings=" + numberOfServings +
                '}';
    }

    public OrderItem convertToEntity() {
        return new OrderItem(menu, order, numberOfServings);
    }
}
