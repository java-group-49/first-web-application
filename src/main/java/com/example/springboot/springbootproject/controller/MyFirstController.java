package com.example.springboot.springbootproject.controller;

import com.example.springboot.springbootproject.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyFirstController {

    @GetMapping("/greetings/{id}")
    public String greetings(@PathVariable Long id) {
        return "Hello from " + id + " user!";
    }

    @GetMapping("/bye")
    public String bye(@RequestParam String status) {
        return "Good bye our " + status + " user!";
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        System.out.println("User name: " + user.getLogin() + ", password: " + user.getPassword());
        return "Saved successfully";
    }
}
