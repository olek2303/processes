package com.example.processes.process.controllers;

import com.example.processes.process.domain.User;
import com.example.processes.process.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    private List<User> fetchUsers() {
        return userRepo.findAll();
    }
}
