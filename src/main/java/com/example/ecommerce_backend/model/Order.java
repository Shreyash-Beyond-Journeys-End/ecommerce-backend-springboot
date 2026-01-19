package com.example.ecommerce_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String id;
    private String userId;
    private double totalAmount;
    private String status;
    private List<OrderItem> items;
}