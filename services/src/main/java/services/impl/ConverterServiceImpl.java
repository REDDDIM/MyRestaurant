package services.impl;

import dto.BaseDto;
import entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import services.ConverterService;

import java.lang.reflect.ParameterizedType;

@Service
public class ConverterServiceImpl<D extends BaseDto, E extends BaseEntity> implements ConverterService<D, E> {


    @Override
    public D convertToDto(E entity) {
        return new ModelMapper().map(entity, (Class<D>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public E convertToEntity(D dto) {
        return new ModelMapper().map(dto, (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
