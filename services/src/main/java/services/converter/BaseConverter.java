package services.converter;

import dto.BaseDto;
import entities.BaseEntity;

public interface BaseConverter<D extends BaseDto, E extends BaseEntity> {
    D convertToDto(E entity);

    E convertToEntity(D dto);
}
