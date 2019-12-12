package services;

import dto.BaseDto;
import entities.BaseEntity;

public interface ConverterService<D extends BaseDto, E extends BaseEntity> {
    D convertToDto(E entity, Class<D> dClass);

    E convertToEntity(D dto, Class<E> eClass);
}
