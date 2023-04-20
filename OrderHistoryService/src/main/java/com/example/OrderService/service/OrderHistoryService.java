package com.example.OrderService.service;

import com.example.OrderService.RESTApi.model.DeliveryStatus;
import com.example.OrderService.RESTApi.model.OrderHistory;
import com.example.OrderService.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderHistoryService {
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public OrderHistory getOrderById(long id) {
        return orderHistoryRepository.findById(id).orElse(null);
    }

    public OrderHistory saveOrder(OrderHistory order){
        orderHistoryRepository.save(order);
        return order;
    }

    public OrderHistory updateDeliveryStatus(long id, DeliveryStatus status) {
        orderHistoryRepository.updateAvailableCapacity(id, status.name());
        OrderHistory order = getOrderById(id);
        order.setDeliveryStatus(status);
        return order;
    }
}
