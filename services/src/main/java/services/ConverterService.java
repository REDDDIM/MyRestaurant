package services;

import dto.BaseDto;
import entities.BaseEntity;

public interface ConverterService<D extends BaseDto, E extends BaseEntity> {
    D convertToDto(E entity);

    E convertToEntity(D dto);
}
