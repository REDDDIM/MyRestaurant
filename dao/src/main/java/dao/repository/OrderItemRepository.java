package dao.repository;

import entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Transactional
    @Modifying
    @Query("update OrderItem oi set oi.position=null where oi.position.id = :positionId")
    public void deletePositionFromOrderItem(@Param("positionId") Long id);
}
