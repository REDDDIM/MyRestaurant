package services;

import entities.User;
import org.springframework.ui.Model;

public interface UserService {
    User load(Long id);
    User save(String firstName,
              String lastName,
              String login,
              String pwd,
              String phoneNumber);
    String authorizeByLoginAndPassword(String login, String pwd, Model model);
}
