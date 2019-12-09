package services.impl;

import dao.repository.*;
import dto.MenuDto;
import entities.Order;
import entities.OrderStatus;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import services.EncryptionService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;


    @Override
    public User load(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(String firstName, String lastName, String login, String pwd, String address, String phoneNumber, String roleName) {
        Role role = null;
        if (roleName != null && !roleName.isEmpty()){
            role = roleRepository.getByName(roleName);
        }
        User user = new User(firstName, lastName, login, encryptionService.encryptString(pwd), address, Long.parseLong(phoneNumber), role);
        return userRepository.save(user);
    }

    @Override
    public User authorizeByLoginAndPassword(String login, String pwd) throws Exception {
        User user = userRepository.findByLogin(login);
        if (user == null) throw new Exception("Пользователь не найден!");
        if (encryptionService.checkPassword(pwd, user.getPassword())) return user;
        else throw new Exception("Неверный пароль!");
    }

    @Override
    public User findByUsername(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllCouriers() {
        return userRepository.getAllCouries();
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
