package com.example.ecommerce_backend.repository;

import com.example.ecommerce_backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}