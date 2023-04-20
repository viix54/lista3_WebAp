package com.example.OrderService.RESTApi.controller;

import com.example.OrderService.RESTApi.model.DeliveryStatus;
import com.example.OrderService.RESTApi.model.Orders;
import com.example.OrderService.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "OrderService Controller")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    @ApiOperation("View Order")
    public Orders getOrder(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    @ApiOperation("Add new Order")
    public Orders setOrder(@RequestBody Orders order){
        return orderService.saveOrder(order);
    }

    @PutMapping("/order/{id}")
    @ApiOperation("Update Delivery Status")
    public Orders updateOrder(@PathVariable long id, @RequestParam DeliveryStatus status){
        return orderService.updateDeliveryStatus(id, status);
    }
}
