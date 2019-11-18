package impl;

import entities.Order;
import interfaces.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(int sessionID, Long idUser, int row, int placeNumber) throws Exception {
        return null;
    }
}
