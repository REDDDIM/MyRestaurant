package services;

import com.fasterxml.jackson.databind.JsonNode;
import dto.PositionDto;
import entities.Position;
import services.exceptions.PositionException;

import java.io.IOException;
import java.util.List;

public interface PositionService {
    List<PositionDto> getAll() throws PositionException;
    PositionDto save(PositionDto positionDto);
    void remove(List<PositionDto> positionDtos);
}
