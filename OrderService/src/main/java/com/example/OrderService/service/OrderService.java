package com.example.OrderService.service;

import com.example.OrderService.RESTApi.model.DeliveryStatus;
import com.example.OrderService.RESTApi.model.Orders;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders saveOrder(Orders order){
        orderRepository.save(order);
        return order;
    }

    public Orders updateDeliveryStatus(long id, DeliveryStatus status) {
        Orders order = getOrderById(id);
        orderRepository.updateAvailableCapacity(order.getDelivery().getId(), status.name());
        order.getDelivery().setStatus(status);
        return order;
    }
}
