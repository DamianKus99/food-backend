package com.zespol11.programowanienzespolowe.order.orderDetails;

import com.zespol11.programowanienzespolowe.order.orderDetails.OrderDetails;
import com.zespol11.programowanienzespolowe.order.orderDetails.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public void saveOrder(OrderDetails orderDetails){
            orderDetailsRepository.save(orderDetails);
    }

    public List<OrderDetails> getOrderDetails(Long id){
        return orderDetailsRepository.findOrderDetails(id);
    }

    @Transactional
    public void paritalUpdate(Long id,
                              OrderDetails oD) {

        OrderDetails orderDetails = orderDetailsRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "orderDetails with id " + id + "does not exists"
                ));



        if(oD.getQuantity() != null &&
        !Objects.equals(oD.getQuantity(), orderDetails.getQuantity())
        ){
            orderDetails.setQuantity(oD.getQuantity());
        }


    }


    public void deleteOrderDetails(Long id) {
        boolean exist = orderDetailsRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException(
                    "OrderDetails with id " + id + " does not exists");
        }

        orderDetailsRepository.deleteById(id);
    }
}
