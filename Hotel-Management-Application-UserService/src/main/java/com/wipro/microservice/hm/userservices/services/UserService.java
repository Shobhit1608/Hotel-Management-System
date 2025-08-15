package com.wipro.microservice.hm.userservices.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.microservice.hm.userservices.entities.User;

import jakarta.validation.Valid;

public interface UserService {

	User addUser(@Valid User user);

	Long getNumberOfUsers();

	

	User getUserById(Long id);

	Page<User> getUsersByState(String state, Pageable pageable);

}
