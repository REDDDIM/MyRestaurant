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

    @GetMapping("/getOrders/{userId}")
    public List<OrderDto> getOrders(@PathVariable("userId") Long userId){
        return orderService.getOrdersForUser(userId);
    }


    @PostMapping("/createOrder")
    public ResponseEntity createOrder(@RequestBody OrderDto order){
            orderService.createOrder(order);
            return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAll();
    }


    @PostMapping("/changeOrderStatus/{orderId}/complete")
    public ResponseEntity completeOrder(@PathVariable("orderId") Long orderId){
        orderService.changeOrderStatus(new Long(orderId), "complete");
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/setOrderToCourier")
    public ResponseEntity setOrderToCourier(@RequestParam("courierId") String courierId, @RequestParam("orderId") String orderId){
        orderService.setOrderToCourier(new Long(courierId), new Long(orderId));
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/getCourierOrders/{courierId}")
    public List<OrderDto> getCourierOrders(@PathVariable("courierId") Long courierId){
        return orderService.getCourierOrders(courierId);
    }
}
