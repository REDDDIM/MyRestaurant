package entities;

import dto.BaseDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@MappedSuperclass
public class BaseEntity<D extends BaseDto> implements Serializable {

    private Long id;

    @Id
    @GeneratedValue
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

    public D convertToDto(){
        return new ModelMapper().map(this, (Class<D>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

}
