package com.josephhieu.orderservice.controller;

import com.josephhieu.orderservice.dto.UserDto;
import com.josephhieu.orderservice.feignclient.UserClient;
import com.josephhieu.orderservice.model.Order;
import com.josephhieu.orderservice.repository.OrderRepository;
import com.josephhieu.orderservice.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();

        // Gọi user-service bằng Feign
        UserDto user = userClient.getUserById(order.getUserId());

        return new OrderResponse(order.getId(), order.getProduct(), order.getPrice(), user);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}