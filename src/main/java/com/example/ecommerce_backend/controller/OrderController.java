package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.model.*;
import com.example.ecommerce_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired private OrderRepository orderRepo;
    @Autowired private CartRepository cartRepo;

    @PostMapping("/place/{userId}")
    public Order place(@PathVariable String userId) {
        List<CartItem> cartItems = cartRepo.findByUserId(userId);
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("PENDING");

        double total = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem ci : cartItems) {
            OrderItem oi = new OrderItem();
            oi.setProductId(ci.getProduct().getId());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(ci.getProduct().getPrice());
            orderItems.add(oi);
            total += ci.getProduct().getPrice() * ci.getQuantity();
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);
        cartRepo.deleteAll(cartItems);
        return orderRepo.save(order);
    }

    @PostMapping("/pay/{orderId}")
    public String pay(@PathVariable String orderId) {
        Order o = orderRepo.findById(orderId).orElse(null);
        if (o != null) {
            o.setStatus("PAID");
            orderRepo.save(o);
            return "Payment Success";
        }
        return "Not Found";
    }
}