package com.zespol11.programowanienzespolowe.order;

import com.zespol11.programowanienzespolowe.order.orderMaster.OrderMasterService;
import com.zespol11.programowanienzespolowe.order.orderMaster.OrderMasters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderMasterService orderMasterService;

    @Autowired
    public OrderController(OrderMasterService orderMasterService) {
        this.orderMasterService = orderMasterService;
    }

    @GetMapping
    public List<OrderMasters> getOrders(){
        return orderMasterService.getOrders();
    }

    @GetMapping(path = "/{id}")
    public Optional<OrderMasters> getOrder(@PathVariable Long id){
        return orderMasterService.getOrder(id);
    }

    @PostMapping
    public void postOrder(@RequestBody OrderMasters orderMasters){
        orderMasterService.saveOrder(orderMasters);
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody OrderMasters orderMasters){
        orderMasterService.saveOrder(orderMasters);
        return ResponseEntity.ok("resource updated");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> partialUpdateOrder(@PathVariable("id") Long id, @RequestBody OrderMasters orderMasters){
        orderMasterService.partialUpdateOrder(id, orderMasters);
        return ResponseEntity.ok("resource updated");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderMasterService.deleteOrder(id);
        return ResponseEntity.ok("resource deleted");
    }




}
