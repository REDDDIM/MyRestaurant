package services;

import entities.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    User load(Long id);
    User save(String firstName,
              String lastName,
              String login,
              String pwd,
              String address,
              String phoneNumber,
              String role);
    User authorizeByLoginAndPassword(String login, String pwd) throws Exception;
    User findByUsername(String login);

    List<User> getAll();

    List<User> getAllCouriers();

    void remove(Long id);
}
