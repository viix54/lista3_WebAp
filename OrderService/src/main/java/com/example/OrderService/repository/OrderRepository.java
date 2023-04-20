package com.example.OrderService.repository;

import com.example.OrderService.RESTApi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Transactional
    @Modifying
    @Query(value = "update DELIVERY set STATUS=?2 where id=?1", nativeQuery = true)
    void updateAvailableCapacity(Long id, String status);
}
