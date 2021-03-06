package services.impl;

import dao.repository.OrderItemRepository;
import dao.repository.PositionRepository;
import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.PositionService;
import services.converter.BaseConverter;
import services.exceptions.PositionException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    @Qualifier("positionConverter")
    private BaseConverter<PositionDto, Position> converter;

    @Override
    public List<PositionDto> getAll() throws PositionException {
        List<Position> entities = positionRepository.findAll();
        if (entities.isEmpty()) throw new PositionException("Список позиций в меню пуст!");
        return converter.convertToDto(entities);
    }

    @Override
    public PositionDto save(PositionDto positionDto) {
        return converter.convertToDto(
                positionRepository.save(
                        converter.convertToEntity(positionDto)));
    }

    @Override
    public void remove(List<PositionDto> positionDtos){
        positionDtos.forEach(m -> {
            orderItemRepository.deletePositionFromOrderItem(m.getId());
            positionRepository.delete(m.getId());
        });
    }
}
