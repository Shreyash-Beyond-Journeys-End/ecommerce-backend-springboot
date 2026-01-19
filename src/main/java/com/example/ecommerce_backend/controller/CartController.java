package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.model.CartItem;
import com.example.ecommerce_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired private CartRepository cartRepository;

    @PostMapping("/add")
    public CartItem add(@RequestBody CartItem item) {
        return cartRepository.save(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getByUser(@PathVariable String userId) {
        return cartRepository.findByUserId(userId);
    }
}