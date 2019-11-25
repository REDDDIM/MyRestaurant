package controller;

import com.fasterxml.jackson.databind.JsonNode;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.MenuService;
import services.UserService;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authorize")
    public String authorize() throws IOException {
        return "kek";
    }

    @RequestMapping(value = "/registration")
    public ResponseEntity registerNewUser(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "surname", required = false) String surname,
                                       @RequestParam(value = "login", required = false) String login,
                                        @RequestParam(value = "address", required = false) String address,
                                        @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                       @RequestParam(value = "password", required = false) String password){
        User user =  userService.save(name, surname, login, password, address, phoneNumber, "client");
        if (user.getId() != null) return new ResponseEntity("user registration completed", HttpStatus.OK);
        else return new ResponseEntity("user id is null", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
