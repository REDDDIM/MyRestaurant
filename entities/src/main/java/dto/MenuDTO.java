package dto;

import entities.Menu;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.text.ParseException;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MenuDTO {
    private Long id;
    private String title;
    private String ingredients;
    private int weight;
    private String unit;
    private double price;

    @Override
    public String toString() {
        return "MenuItemDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", weight=" + weight +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }

    public Menu convertToEntity() throws ParseException {
        return new Menu(id, title, ingredients, weight, unit, price);
    }
}
