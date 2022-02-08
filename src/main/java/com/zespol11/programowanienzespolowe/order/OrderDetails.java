package com.zespol11.programowanienzespolowe.order;

import com.zespol11.programowanienzespolowe.menu.MenuItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDetails {

    @Id
    @SequenceGenerator(
            name = "orderDetailsSequence",
            sequenceName = "order_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_details_sequence"
    )
    private Long OrderDetailId;

    @ManyToOne()
    @JoinColumn(name = "ordermasters_id")
    private OrderMasters orderMastersId;

    private Double MenuItemPrice;

    private Integer Quantity;

    @ManyToOne()
    @JoinColumn(name = "menuitem_id")
    private MenuItem menuItem;

}
