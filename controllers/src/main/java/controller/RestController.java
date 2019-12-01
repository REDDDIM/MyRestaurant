package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import entities.User;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.EncryptionService;
import services.MenuService;
import services.OrderService;
import services.UserService;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/login")
    public ResponseEntity login(@RequestParam("login") String login,
                            @RequestParam("password") String password) {
        try{
            User user = userService.authorizeByLoginAndPassword(login, password);
            user.setPassword(password);
            return new ResponseEntity(user, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/registration")
    public ResponseEntity registerNewUser(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "surname") String surname,
                                       @RequestParam(value = "login") String login,
                                        @RequestParam(value = "address") String address,
                                        @RequestParam(value = "phoneNumber") String phoneNumber,
                                       @RequestParam(value = "password") String password){

        try {
            User user =  userService.save(name, surname, login, password, address, phoneNumber, "ROLE_client");
            return new ResponseEntity("user registration completed", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/allmenu")
    public ResponseEntity getAllMenu(){
        try {
            return new ResponseEntity(menuService.getAllDtos(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/addmenu")
    public ResponseEntity addMenu(@RequestBody String body){
        try {
            return new ResponseEntity(menuService.saveFromJson(body), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/removemenu")
    public ResponseEntity removeMenu(@RequestBody String body){
        try {
            menuService.remove(body);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/getOrders")
    public ResponseEntity getOrders(@RequestParam("userId") String userId){
        try {
            return new ResponseEntity(orderService.getOrdersForUser(new Long(userId)), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
