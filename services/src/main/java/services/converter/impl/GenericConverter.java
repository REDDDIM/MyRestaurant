package services.converter.impl;

import dto.BaseDto;
import entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import services.converter.BaseConverter;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericConverter<D extends BaseDto, E extends BaseEntity> implements BaseConverter<D, E> {
    @Override
    public D convertToDto(E entity) {
        return new ModelMapper().map(entity, (Class<D>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
    }

    @Override
    public E convertToEntity(D dto) {
        return new ModelMapper().map(dto, (Class<E>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1]));
    }

    @Override
    public List<D> convertToDto(List<E> entityList) {
        return entityList.stream().map(e -> new ModelMapper().map(e, (Class<D>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]))).collect(Collectors.toList());
    }

    @Override
    public List<E> convertToEntity(List<D> dtoList) {
        return dtoList.stream().map(d -> new ModelMapper().map(d, (Class<E>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1]))).collect(Collectors.toList());
    }


}
