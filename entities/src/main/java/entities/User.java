package entities;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_user")
    private Long id;
    @Column (name = "role")
    private Role role;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;
    @Column (name = "address")
    private String address;
    @Column (name = "phone_number")
    private Long phoneNumber;

    public User convertToDto() {
        return new User(id, role, name, surname, login, password, address, phoneNumber);
    }
}
