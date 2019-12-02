package dao.repository;

import entities.OrderType;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {

    @Query("FROM OrderType WHERE name=:name")
    OrderType getByName(@Param("name") String name);
}
