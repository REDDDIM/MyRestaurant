package controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.MenuService;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/adddishtomenu")
    public JsonNode addDishToMenu(@RequestParam("title") String title,
                                  @RequestParam("ingredients") String ingredients,
                                  @RequestParam("weight") String weight,
                                  @RequestParam("unit") String unit,
                                  @RequestParam("price") String price) throws IOException {
        return menuService.saveAndReturnAsJson(title, ingredients, weight, unit, price);
    }

    @RequestMapping(value = "/authorize")
    public String authorize() throws IOException {
        return "kek";
    }
}
