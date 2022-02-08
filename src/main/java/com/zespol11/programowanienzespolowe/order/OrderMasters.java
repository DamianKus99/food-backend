package com.zespol11.programowanienzespolowe.order;

import com.zespol11.programowanienzespolowe.userRegistration.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderMasters {

    @Id
    @SequenceGenerator(
            name = "orderSequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderMasterId;

    private Long orderNumber;

    @OneToOne
    @JoinColumn
    private User customerId;

    private String pMethod;

    private Double totalAmount;



}
