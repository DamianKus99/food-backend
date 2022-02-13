package com.zespol11.programowanienzespolowe.order.orderDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.zespol11.programowanienzespolowe.food.FoodItem;
import com.zespol11.programowanienzespolowe.order.orderMaster.OrderMasters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.List;



@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderDetailId"
)
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordermaster_id")
    private OrderMasters orderMaster;

    @ManyToMany
    private List<FoodItem> foodItem;

    private Double foodItemPrice;

    private Integer quantity;

}
