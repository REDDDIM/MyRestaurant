package dto;

import entities.Position;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.text.ParseException;


public class PositionDto extends BaseDto{

    private String title;
    private String ingredients;
    private Integer weight;
    private String unit;
    private BigDecimal price;

    public PositionDto(Long id, String title, String ingredients, Integer weight, String unit, BigDecimal price) {
        this.setId(id);
        this.title = title;
        this.ingredients = ingredients;
        this.weight = weight;
        this.unit = unit;
        this.price = price;
    }

    public PositionDto() {
    }

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
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
