package dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
//@Getter
//@Setter
@EqualsAndHashCode
public class UserDto extends BaseDto {

    private RoleDto role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String address;
    private Long phoneNumber;

    public UserDto() {
    }

    public UserDto(Long id, RoleDto role, String name, String surname, String login, String password, String address, Long phoneNumber) {
        this.setId(id);
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
