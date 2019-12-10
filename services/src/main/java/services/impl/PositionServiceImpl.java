package services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import dao.repository.PositionRepository;
import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.PositionService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository menuRepository;
    @Override
    public List<PositionDto> getAllDtos() {
        List<PositionDto> menuDtoList = new ArrayList<>();
        menuRepository.findAll().forEach(m -> menuDtoList.add(m.convertToDto()));
        return menuDtoList;
    }

    @Override
    public JsonNode saveAndReturnAsJson(String title, String ingredients, String weight, String unit, String price) throws IOException {
        Position menuEntity = new Position();
        menuEntity.setTitle(title);
        menuEntity.setIngredients(ingredients);
        menuEntity.setWeight(Integer.parseInt(weight));
        menuEntity.setUnit(unit);
        menuEntity.setPrice(new BigDecimal(price));
        Position m = menuRepository.save(menuEntity);
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(gson.toJson(m).toString());
    }

    @Override
    public Position saveFromJson(String menuString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Position menu = mapper.readValue(menuString, Position.class);
        return save(menu);
    }

    @Override
    public Position save(Position menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void remove(String menuListString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Position[] menuArray= mapper.readValue(menuListString, Position[].class);
        Arrays.asList(menuArray).forEach(m -> menuRepository.delete(m));
    }
}
