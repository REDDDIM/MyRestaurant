package controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public UserDto login(@RequestParam("login") String login,
                         @RequestParam("password") String password) throws Exception {
        return userService.authorizeByLoginAndPassword(login, password);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity registerNewUser(@RequestBody UserDto userDto){

        try {
            userService.createNewUser(userDto);
            return new ResponseEntity("user registration completed", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
