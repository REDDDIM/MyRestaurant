package interfaces;

import entities.Delivery;
import java.util.List;

public interface DeliveryService {
    List<Delivery> getAllDelivery();
    Delivery getDeliveryById(Long id);
    void createDelivery(Delivery delivery) throws Exception;
    void updateDelivery(Delivery delivery);
    void deleteDelivery(Delivery delivery);
}
