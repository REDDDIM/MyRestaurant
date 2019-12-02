package dao.repository;

import entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    @Query("FROM OrderStatus WHERE name=:name")
    OrderStatus getByName(@Param("name") String name);
}
