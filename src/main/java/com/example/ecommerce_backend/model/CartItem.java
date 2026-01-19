package com.example.ecommerce_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "cart_items")
@Data
public class CartItem {
    @Id
    private String id;
    private String userId;
    private Product product;
    private int quantity;
}