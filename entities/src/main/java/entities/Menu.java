package entities;

import dto.MenuDto;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity<MenuDto> {

    @Column (name = "title")
    private String title;
    @Column (name = "ingredients")
    private String ingredients;
    @Column (name = "weight")
    private Integer weight;
    @Column (name = "unit")
    private String unit;
    @Column (name = "price")
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
