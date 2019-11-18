package dto;

import entities.Role;
import entities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private Role role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String address;
    private Long phoneNumber;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public User convertToEntity() {
        return new User(id, role, name, surname, login, password, address, phoneNumber);
    }
}
