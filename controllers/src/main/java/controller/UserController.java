package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getAllUsers")
    public ResponseEntity getAllUsers(){
        try {
            return new ResponseEntity(userService.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAllCouriers")
    public ResponseEntity getAllCouriers(){
        try {
            return new ResponseEntity(userService.getAllCouriers(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
