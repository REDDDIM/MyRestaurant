package services.impl;

import dao.repository.MenuRepository;
import dao.repository.RoleRepository;
import dao.repository.UserRepository;
import dto.MenuDto;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RoleRepository roleRepository;


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
        User user = new User(firstName, lastName, login, pwd, address, Long.parseLong(phoneNumber), role);
        return userRepository.save(user);
    }

    @Override
    public String authorizeByLoginAndPassword(String login, String pwd, Model model) {
        User user = userRepository.getByLoginAndPwd(login, pwd);
        String result = new String();
        switch (user.getRole().getName()){
            case ("client") :
                List<MenuDto> menuDtoList = new ArrayList<>();
                menuRepository.findAll().forEach(m ->menuDtoList.add(m.convertToDto()));
                model.addAttribute("menu", menuDtoList);
                result = "clientmenupage";
                break;
            case ("admin") :
                result = "adminpage";
        }
        return result;
    }
}
