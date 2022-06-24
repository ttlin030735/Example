package com.revature.Resources;

import com.revature.Entity.Orders;
import com.revature.Entity.User;
import com.revature.Service.OrdersService;
import com.revature.Service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrdersResource {
    private final OrdersService orderService;
    private final UserService userService;

    @GetMapping("/getOrders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        List<Orders> orderList = orderService.findAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/find/{ordersID}")
    public ResponseEntity<Orders> getOrder(@PathVariable("ordersId") Long ordersID){
        Orders order = orderService.findByOrderId(ordersID);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrders(@RequestBody Orders order){
        Orders updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order){
        User user = userService.findByUserID(order.getUserId());
        if(user != null) {
            return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") Long orderId){
        Orders orders = orderService.findByOrderId(orderId);
        if(orders != null){
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
