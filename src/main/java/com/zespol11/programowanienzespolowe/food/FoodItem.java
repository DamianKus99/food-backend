package com.zespol11.programowanienzespolowe.food;

import com.zespol11.programowanienzespolowe.order.orderDetails.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodItemId;

    private String name;

    private Double price;


}
