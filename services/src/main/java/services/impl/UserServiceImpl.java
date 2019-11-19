package services.impl;

import dao.repository.MenuRepository;
import dao.repository.UserRepository;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;
    @Override
    public User load(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(String firstName, String lastName, String login, String pwd, String phoneNumber) {
        return userRepository.save(new User(firstName, lastName, login, pwd, Long.parseLong(phoneNumber)));

    }

    @Override
    public String authorizeByLoginAndPassword(String login, String pwd, Model model) {
        User user = userRepository.getByLoginAndPwd(login, pwd);
        String result = new String();
        switch (user.getRole().getName()){
            case ("client") :
                model.addAttribute("menu", menuRepository.findAll());
                result = "menupage";
                break;
            case ("admin") :
                result = "adminpage";
        }
        return result;
    }
}
