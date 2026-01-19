package com.example.ecommerce_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "payments")
@Data
public class Payment {
    @Id
    private String id;
    private String orderId;
    private String transactionId;
    private String paymentStatus;
    private double amount;
}