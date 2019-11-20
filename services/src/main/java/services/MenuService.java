package services;

import com.fasterxml.jackson.databind.JsonNode;
import dto.MenuDto;
import java.io.IOException;
import java.util.List;

public interface MenuService {
    List<MenuDto> getAllDtos();
    JsonNode saveAndReturnAsJson(String title,
                                  String ingredients,
                                  String weight,
                                  String unit,
                                  String price) throws IOException;
}
