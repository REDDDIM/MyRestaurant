package controller;

import dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/getOrders")
    public List<OrderDto> getOrders(@RequestParam("userId") String userId){
        return orderService.getOrdersForUser(new Long(userId));
    }


    @PostMapping("/createOrder")
    public ResponseEntity createOrder(@RequestBody OrderDto order){
            orderService.createOrder(order);
            return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/getAllOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAll();
    }

    @PostMapping("/changeOrderStatus")
    public ResponseEntity changeOrderStatus(@RequestParam("orderId") String orderId, @RequestParam("newStatusName") String newStatusName){
        orderService.changeOrderStatus(new Long(orderId), newStatusName);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/setOrderToCourier")
    public ResponseEntity setOrderToCourier(@RequestParam("courierId") String courierId, @RequestParam("orderId") String orderId){
        orderService.setOrderToCourier(new Long(courierId), new Long(orderId));
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/getCourierOrders")
    public List<OrderDto> getCourierOrders(@RequestParam("courierId") String courierId){
        return orderService.getCourierOrders(new Long(courierId));
    }
}
