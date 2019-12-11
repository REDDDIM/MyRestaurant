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
    private Position position;

    @Column (name = "number_of_servings")
    private Integer numberOfServings;

    @ManyToOne
    @JoinColumn (name = "position_id")
    public Position getMenu() {
        return position;
    }

    public void setMenu(Position position) {
        this.position = position;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
