package services.impl;

import dao.repository.PositionRepository;
import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.PositionService;
import services.converter.BaseConverter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    @Qualifier("positionConverter")
    private BaseConverter<PositionDto, Position> converter;

    @Override
    public List<PositionDto> getAll() {
        return positionRepository.findAll()
                .stream().map(e -> converter.convertToDto(e)).
                        collect(Collectors.toList());
    }

    @Override
    public PositionDto save(PositionDto positionDto) {
        return converter.convertToDto(
                positionRepository.save(
                        converter.convertToEntity(positionDto)));
    }

    @Override
    public void remove(List<PositionDto> positionDtos){
        positionDtos.forEach(m -> positionRepository.delete(m.getId()));
    }
}
