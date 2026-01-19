package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.model.*;
import com.example.ecommerce_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired private OrderRepository orderRepo;
    @Autowired private PaymentRepository paymentRepo;

    @PostMapping("/pay/{orderId}")
    public Payment processPayment(@PathVariable String orderId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus("PAID");
            orderRepo.save(order);

            Payment payment = new Payment();
            payment.setOrderId(orderId);
            payment.setAmount(order.getTotalAmount());
            payment.setPaymentStatus("SUCCESS");
            payment.setTransactionId(UUID.randomUUID().toString());

            return paymentRepo.save(payment);
        }
        return null;
    }
}