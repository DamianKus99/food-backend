package com.zespol11.programowanienzespolowe.order.orderMaster;

import com.zespol11.programowanienzespolowe.order.orderMaster.OrderMasters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMasters, Long> {
}
