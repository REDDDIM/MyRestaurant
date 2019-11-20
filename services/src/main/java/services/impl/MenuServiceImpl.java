package services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import dao.repository.MenuRepository;
import dto.MenuDto;
import entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MenuService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Override
    public List<MenuDto> getAllDtos() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        menuRepository.findAll().forEach(m -> menuDtoList.add(m.convertToDto()));
        return menuDtoList;
    }

    @Override
    public JsonNode saveAndReturnAsJson(String title, String ingredients, String weight, String unit, String price) throws IOException {
        Menu menuEntity = new Menu();
        menuEntity.setTitle(title);
        menuEntity.setIngredients(ingredients);
        menuEntity.setWeight(Integer.parseInt(weight));
        menuEntity.setUnit(unit);
        menuEntity.setPrice(new BigDecimal(price));
        Menu m = menuRepository.save(menuEntity);
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(gson.toJson(m).toString());
    }
}
