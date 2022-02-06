package com.zespol11.programowanienzespolowe.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    @Query("SELECT o FROM OrderDetails o WHERE o.orderMastersId.orderMasterId = :id")
    List<OrderDetails> findOrderDetails(Long id);
}
