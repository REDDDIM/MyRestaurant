package services;

import com.fasterxml.jackson.databind.JsonNode;
import dto.PositionDto;
import entities.Position;

import java.io.IOException;
import java.util.List;

public interface PositionService {
    List<PositionDto> getAll();
    PositionDto save(PositionDto positionDto);
    void remove(List<PositionDto> positionDtos);
}
