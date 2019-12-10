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
public class OrderItem extends BaseEntity {
    private Position menu;

    @Column (name = "number_of_servings")
    private Integer numberOfServings;

    @ManyToOne
    @JoinColumn (name = "menu_id")
    public Position getMenu() {
        return menu;
    }

    public void setMenu(Position menu) {
        this.menu = menu;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
