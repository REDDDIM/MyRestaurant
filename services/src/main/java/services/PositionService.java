package services;

import com.fasterxml.jackson.databind.JsonNode;
import dto.PositionDto;
import entities.Position;

import java.io.IOException;
import java.util.List;

public interface PositionService {
    List<PositionDto> getAllDtos();
    JsonNode saveAndReturnAsJson(String title,
                                  String ingredients,
                                  String weight,
                                  String unit,
                                  String price) throws IOException;
    Position saveFromJson(String menuString) throws IOException;
    Position save(Position menu);
    void remove(String menuListString) throws IOException;
}
