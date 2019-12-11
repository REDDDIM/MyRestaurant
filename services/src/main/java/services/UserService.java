package services;

import dto.UserDto;
import entities.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    User load(Long id);
    User createNewUser(UserDto userDto);
    UserDto authorizeByLoginAndPassword(String login, String pwd) throws Exception;
    User findByUsername(String login);

    List<UserDto> getAll();

    List<UserDto> getAllCouriers();

    void remove(Long id);
}
