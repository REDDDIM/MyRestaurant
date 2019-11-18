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
@Table(name = "order_item")
public class OrderItem {
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_menu")
    private Menu menu;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_order")
    private Order order;
    @Column (name = "number_of_servings")
    private int numberOfServings;

    public OrderItem(Menu menu, Order order, int numberOfServings) {
        this.menu = menu;
        this.order = order;
        this.numberOfServings = numberOfServings;
    }

    public OrderItem convertToDto() {
        return new OrderItem(menu.convertToDto(), order.convertToDto(), numberOfServings);
    }
}
