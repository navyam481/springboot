package com.wipro.gateway.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id) {
        return "Order Details for Order ID: " + id;
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody String order) {
        return "Order Created: " + order;
    }
}
