package com.zespol11.programowanienzespolowe.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }


    @GetMapping(path = "/{id}")
    public List<OrderDetails> getOrderDetails(@PathVariable Long id){
     return orderDetailsService.getOrderDetails(id);
    }

    @PostMapping
    public ResponseEntity<?> postOrderDetails(@RequestBody OrderDetails orderDetails){
        orderDetailsService.saveOrder(orderDetails);
        return ResponseEntity.ok("resource added");
    }

    @PutMapping
    public ResponseEntity<?> updateOrderDetails(@RequestBody OrderDetails orderDetails){
        orderDetailsService.saveOrder(orderDetails);
        return ResponseEntity.ok("resource updated");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> partialUpdateOrderDetails(@PathVariable Long id, @RequestBody OrderDetails orderDetails){
        orderDetailsService.paritalUpdate(id, orderDetails);
        return ResponseEntity.ok("resource updated");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteOrderDetails(@PathVariable Long id){
        orderDetailsService.deleteOrderDetails(id);
        return ResponseEntity.ok("resource deleted");
    }



}
