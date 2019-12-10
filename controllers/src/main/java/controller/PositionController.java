package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MenuService;

@RestController(value = "/position")
public class PositionController {

    @Autowired
    MenuService menuService;

    @PostMapping("/allmenu")
    public ResponseEntity getAllMenu(){
        try {
            return new ResponseEntity(menuService.getAllDtos(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addmenu")
    public ResponseEntity addMenu(@RequestBody String body){
        try {
            return new ResponseEntity(menuService.saveFromJson(body), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/removemenu")
    public ResponseEntity removeMenu(@RequestBody String body){
        try {
            menuService.remove(body);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
