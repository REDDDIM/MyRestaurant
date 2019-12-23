package services.converter;

import dto.BaseDto;
import entities.BaseEntity;

import java.util.List;

public interface BaseConverter<D extends BaseDto, E extends BaseEntity> {
    D convertToDto(E entity);

    E convertToEntity(D dto);

    List<D> convertToDto(List<E> entityList);

    List<E> convertToEntity(List<D> dtoList);
}
