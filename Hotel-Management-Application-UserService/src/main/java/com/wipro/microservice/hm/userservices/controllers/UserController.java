package com.wipro.microservice.hm.userservices.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.microservice.hm.userservices.entities.User;
import com.wipro.microservice.hm.userservices.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }
    
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping("/numberOfUsers")
    public Long getNumberOfUsers() {
        return userService.getNumberOfUsers();
    }
    
    @GetMapping("/userBystate/{state}")
    public Page<User> getUsersByState(@PathVariable String state, Pageable pageable) {
        return userService.getUsersByState(state, pageable);
    }
	
}

