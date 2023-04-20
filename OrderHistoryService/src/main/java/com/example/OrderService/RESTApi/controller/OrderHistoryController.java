package com.example.OrderService.RESTApi.controller;

import com.example.OrderService.RESTApi.model.DeliveryStatus;
import com.example.OrderService.RESTApi.model.OrderHistory;
import com.example.OrderService.service.OrderHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "OrderHistoryService Controller")
public class OrderHistoryController {

    private final OrderHistoryService orderHistoryService;

    @Autowired
    public OrderHistoryController(OrderHistoryService orderHistoryService){
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping("/orderHistory/{id}")
    @ApiOperation("View Order History")
    public OrderHistory getOrderHistory(@PathVariable Integer id){
        return orderHistoryService.getOrderById(id);
    }

    @PostMapping("/orderHistory")
    @ApiOperation("Add new Order")
    public OrderHistory setOrderHistory(@RequestBody OrderHistory order){
        return orderHistoryService.saveOrder(order);
    }

    @PutMapping("/orderHistory/{id}")
    @ApiOperation("Update Delivery Status")
    public OrderHistory updateOrderHistory(@PathVariable long id, @RequestParam DeliveryStatus status){
        return orderHistoryService.updateDeliveryStatus(id, status);
    }
}
