package com.example.OrderService.RESTApi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "ORDER_HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column (name = "CUSTOMER_NAME")
    private String customerName;

    @Column (name = "COURIER_NAME")
    private String courierName;

    @Enumerated(EnumType.STRING)
    @Column (name = "DELIVERY_STATUS")
    private DeliveryStatus deliveryStatus;

    @Column (name = "PRODUCT_NAMES")
    private String productNames;

    @Column (name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
}
