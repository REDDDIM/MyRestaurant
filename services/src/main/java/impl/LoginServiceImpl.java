package impl;

import dao.repository.UserRepository;
import entities.User;
import interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private String login;
    private String password;

    @Autowired
    private UserRepository userRepository;

    public LoginServiceImpl() {
        login = " ";
        password = " ";
    }

    public boolean check() {
        return userRepository.findAll().stream()
                .anyMatch(user -> user.getPosition().equals(login) && user.getPassword().equals(password));
    }

    @Override
    public int getUserID() {
        User user = (User) userRepository.findAll().stream()
                .filter(item -> item.getPosition().equals(login) && item.getPassword().equals(password)).toArray()[0];
        return user.getID();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
