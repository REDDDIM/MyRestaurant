package dto;

import entities.BaseEntity;
import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

public class BaseDto<E extends BaseEntity> {
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

    public E convertToEntity(){
        return new ModelMapper().map(this, (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
