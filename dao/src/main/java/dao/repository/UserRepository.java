package dao.repository;

import dto.UserDto;
import entities.BaseEntity;
import entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.FROM;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE login=:login and password=:pwd")
    User getByLoginAndPwd(@Param("login") String login, @Param("pwd") String pwd);

    @Query("FROM User WHERE login=:login")
    User findByLogin(@Param("login") String login);

    @Query("FROM User WHERE role.name = 'ROLE_courier'")
    List<User> getAllCouries();

    @Query("FROM User WHERE role.name = :role")
    List<User> getByRole(@Param("role") String role);


}
