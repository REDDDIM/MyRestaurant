package services.impl;

import dao.repository.*;
import dto.UserDto;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ConverterService;
import services.EncryptionService;
import services.UserService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    ConverterService<UserDto, User> converterService;


    @Override
    public User load(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User createNewUser(UserDto userDto) {
        Role role = null;
        if (userDto.getRole() != null && !userDto.getRole().getName().isEmpty()){
            role = roleRepository.getByName(userDto.getRole().getName());
        }
        User user = converterService.convertToEntity(userDto, User.class);
        user.setPassword(encryptionService.encryptString(userDto.getPassword()));
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public UserDto authorizeByLoginAndPassword(String login, String pwd) throws Exception {
        UserDto userDto = converterService.convertToDto(userRepository.findByLogin(login), UserDto.class);
        if (userDto == null) throw new Exception("Пользователь не найден!");
        if (encryptionService.checkPassword(pwd, userDto.getPassword())){
            userDto.setPassword(pwd);
            return userDto;
        }
        else throw new Exception("Неверный пароль!");
    }

    @Override
    public User findByUsername(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().
                map(e -> converterService.convertToDto(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllCouriers() {
        return userRepository.getAllCouries().stream().
                map(e -> converterService.convertToDto(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
