package interfaces;

import java.util.List;
import entities.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user) throws Exception;
    void updateUser(User employee);
    void deleteUser(User employee);
}
