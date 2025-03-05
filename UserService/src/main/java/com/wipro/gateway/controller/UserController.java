package com.wipro.gateway.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return "User Details for User ID: " + id;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody String user) {
        return "User Registered: " + user;
    }
}

