package dao.repository;

import entities.BaseEntity;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE login=:login and password=:pwd")
    User getByLoginAndPwd(@Param("login") String login, @Param("pwd") String pwd);

    @Query("FROM User WHERE login=:login")
    User findByLogin(@Param("login") String login);
}
