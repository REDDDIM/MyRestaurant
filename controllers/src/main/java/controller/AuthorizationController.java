package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
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

    @PostMapping(value = "/registration")
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
}
