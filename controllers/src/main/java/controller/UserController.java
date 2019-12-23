package controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;
import services.exceptions.UserException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*@PostMapping("/getAllUsers")
    public List<UserDto> getAllUsers() throws UserException {
        return userService.getAll();
    }

    @PostMapping("/getAllCouriers")
    public List<UserDto> getAllCouriers() throws UserException {
        return userService.getAllCouriers();
    }*/

    @GetMapping("/users")
    public List<UserDto> getUsers() throws UserException {
        return userService.getAll();
    }

    @GetMapping("/users/{role}")
    public List<UserDto> getUsers(@PathVariable(name = "role") String role) throws UserException {
        return userService.getByRole(role);
    }
}
