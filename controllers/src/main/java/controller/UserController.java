package controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserDto> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/getAllCouriers")
    public List<UserDto> getAllCouriers(){
        return userService.getAllCouriers();
    }
}
