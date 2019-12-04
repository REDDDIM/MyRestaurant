package dao.repository;

import entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("FROM Order WHERE user.id=:userId")
    List<Order> getByUserId(@Param("userId") Long userId);

    @Query("FROM Order WHERE courier.id=:courierId")
    List<Order> getCourierOrders(@Param("courierId") Long courierId);
}
