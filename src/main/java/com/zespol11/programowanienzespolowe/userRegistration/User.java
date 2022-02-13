package com.zespol11.programowanienzespolowe.userRegistration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String customerName;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//    private List<OrderMasters> orders;

    //    private String surname;
//    private String email;
//    private String password;



}
