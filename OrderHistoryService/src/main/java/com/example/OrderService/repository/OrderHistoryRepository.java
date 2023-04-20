package com.example.OrderService.repository;

import com.example.OrderService.RESTApi.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    @Transactional
    @Modifying
    @Query(value = "update ORDER_HISTORY set DELIVERY_STATUS=?2 where ORDER_ID=?1", nativeQuery = true)
    void updateAvailableCapacity(Long id, String status);
}
