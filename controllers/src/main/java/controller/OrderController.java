package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/getOrders")
    public ResponseEntity getOrders(@RequestParam("userId") String userId){
        try {
            return new ResponseEntity(orderService.getOrdersForUser(new Long(userId)), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/createOrder")
    public ResponseEntity createOrder(@RequestParam("order") String order){
        try {
            orderService.createOrder(order);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAllOrders")
    public ResponseEntity getAllOrders(){
        try {
            return new ResponseEntity(orderService.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/changeOrderStatus")
    public ResponseEntity changeOrderStatus(@RequestParam("orderId") String orderId, @RequestParam("newStatusName") String newStatusName){
        try {
            orderService.changeOrderStatus(new Long(orderId), newStatusName);
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/setOrderToCourier")
    public ResponseEntity setOrderToCourier(@RequestParam("courierId") String courierId, @RequestParam("orderId") String orderId){
        try {
            orderService.setOrderToCourier(new Long(courierId), new Long(orderId));
            return new ResponseEntity(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getCourierOrders")
    public ResponseEntity getCourierOrders(@RequestParam("courierId") String courierId){
        try {
            return new ResponseEntity(orderService.getCourierOrders(new Long(courierId)), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
