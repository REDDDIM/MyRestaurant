package services.impl;

import dto.BaseDto;
import entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import services.ConverterService;

import javax.jws.WebParam;
import java.lang.reflect.ParameterizedType;

@Service
public class ConverterServiceImpl<D extends BaseDto, E extends BaseEntity> implements ConverterService<D, E> {
    @Override
    public D convertToDto(E entity, Class<D> dClass) {
        return new ModelMapper().map(entity, dClass);
    }

    @Override
    public E convertToEntity(D dto, Class<E> eClass) {
        return new ModelMapper().map(dto, eClass);
    }
}
