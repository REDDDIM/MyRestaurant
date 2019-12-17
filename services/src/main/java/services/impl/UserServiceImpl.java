package services.impl;

import dao.repository.*;
import dto.UserDto;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.EncryptionService;
import services.UserService;
import services.converter.BaseConverter;
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
    @Qualifier("userConverter")
    BaseConverter<UserDto, User> converter;


    @Override
    public User load(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public UserDto createNewUser(UserDto userDto) {
        Role role = null;
        if (userDto.getRole() != null && !userDto.getRole().getName().isEmpty()){
            role = roleRepository.getByName(userDto.getRole().getName());
        }
        User user = converter.convertToEntity(userDto);
        user.setPassword(encryptionService.encryptString(userDto.getPassword()));
        user.setRole(role);
        user = userRepository.save(user);
        return converter.convertToDto(user);
    }

    @Override
    public UserDto authorizeByLoginAndPassword(String login, String pwd) throws Exception {
        UserDto userDto = converter.convertToDto(userRepository.findByLogin(login));
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
                map(e -> converter.convertToDto(e)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllCouriers() {
        return userRepository.getAllCouries().stream().
                map(e -> converter.convertToDto(e)).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
