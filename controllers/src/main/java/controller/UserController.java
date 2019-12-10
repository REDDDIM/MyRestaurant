package controller;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/getAllCouriers")
    public List<User> getAllCouriers(){
        return userService.getAllCouriers();
    }
}
