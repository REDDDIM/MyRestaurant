package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/signin"})
    public String getSignInPage(){
        return "signin";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("login") String login, @RequestParam("pwd") String pwd){
        return userService.authorizeByLoginAndPassword(login, pwd, model);
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/signup")
    public String getSignUp(){
        return "signup";
    }
    @PostMapping("/registration")
    public String registrationUser(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("login") String login,
                                   @RequestParam("pwd") String pwd,
                                   @RequestParam("phoneNumber") String phoneNumber){

        userService.save(firstName,
                 lastName,
                 login,
                 pwd,
                 phoneNumber);
        return "signin";
    }
}
