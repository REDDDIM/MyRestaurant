package dto;

import entities.BaseEntity;
import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

public class BaseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName()+"{id="+getId()+"}";
    }
}
