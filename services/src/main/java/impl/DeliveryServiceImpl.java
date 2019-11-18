package impl;

import dao.repository.DeliveryRepository;
import entities.Delivery;
import interfaces.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findOne(id);
    }

    @Override
    public void createDelivery(Delivery delivery) throws Exception {
        deliveryRepository.saveAndFlush(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        deliveryRepository.saveAndFlush(delivery);
    }

    @Override
    public void deleteDelivery(Delivery delivery) {
        deliveryRepository.delete(delivery);
    }
}
