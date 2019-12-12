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
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
