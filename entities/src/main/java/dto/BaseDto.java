package dto;

import java.io.Serializable;

public class BaseDto implements Serializable {
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
