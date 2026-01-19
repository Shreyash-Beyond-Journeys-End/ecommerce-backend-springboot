package com.example.ecommerce_backend.repository;

import com.example.ecommerce_backend.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}