package com.example.ecommerce_backend.repository;

import com.example.ecommerce_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}