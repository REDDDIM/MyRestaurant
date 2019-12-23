package services;

import dto.UserDto;
import entities.User;
import org.springframework.ui.Model;
import services.exceptions.UserException;

import java.util.List;

public interface UserService {
    User load(Long id);
    UserDto createNewUser(UserDto userDto) throws UserException;
    UserDto authorizeByLoginAndPassword(String login, String pwd) throws Exception;
    User findByUsername(String login);

    List<UserDto> getAll() throws UserException;

    List<UserDto> getAllCouriers() throws UserException;

    List<UserDto> getByRole(String role) throws UserException;

    void remove(Long id);
}
