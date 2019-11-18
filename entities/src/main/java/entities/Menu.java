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
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_menu")
    private Long id;
    @Column (name = "title")
    private String title;
    @Column (name = "ingredients")
    private String ingredients;
    @Column (name = "weight")
    private int weight;
    @Column (name = "unit")
    private String unit;
    @Column (name = "price")
    private double price;


    public Menu convertToDto() {
        return new Menu(id, title, ingredients, weight, unit, price);
    }
}
