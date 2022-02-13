package com.zespol11.programowanienzespolowe.order.orderMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderMasterService {

    private final OrderMasterRepository orderMasterRepository;

    @Autowired
    public OrderMasterService(OrderMasterRepository orderMasterRepository) {
        this.orderMasterRepository = orderMasterRepository;
    }

    public List<OrderMasters> getOrders(){
        return orderMasterRepository.findAll();
    }

    public void saveOrder(OrderMasters orderMasters){
        orderMasterRepository.save(orderMasters);
    }

    public Optional<OrderMasters> getOrder(Long id) {
        return orderMasterRepository.findById(id);
    }


    @Transactional
    public void partialUpdateOrder(Long id,
                                   OrderMasters oM) {
        OrderMasters orderMasters = orderMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "orderMaster with id " + id + "does not exist"
                ));

        if(oM.getOrderNumber() != null
                && !Objects.equals(oM.getOrderNumber(), orderMasters.getOrderNumber())){
            orderMasters.setOrderNumber(oM.getOrderNumber());
        }


        orderMasterRepository.save(orderMasters);

    }

    public void deleteOrder(Long id) {
        boolean exist = orderMasterRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException(
                    "Order with id " + id + "does not exsists"
            );
        }

        orderMasterRepository.deleteById(id);
    }
}