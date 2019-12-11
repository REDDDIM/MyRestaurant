package services.impl;

import dao.repository.PositionRepository;
import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ConverterService;
import services.PositionService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository menuRepository;

    @Autowired
    private ConverterService<PositionDto, Position> converterService;

    @Override
    public List<PositionDto> getAll() {
        return menuRepository.findAll()
                .stream().map(e -> converterService.convertToDto(e)).
                        collect(Collectors.toList());
    }

    @Override
    public PositionDto save(PositionDto positionDto) {
        return converterService.convertToDto(menuRepository.save(converterService.convertToEntity(positionDto)));
    }

    @Override
    public void remove(List<PositionDto> positionDtos){
        positionDtos.forEach(m -> menuRepository.delete(m.getId()));
    }
}
