package com.wipro.microservice.hm.userservices.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.microservice.hm.userservices.entities.User;
import com.wipro.microservice.hm.userservices.exceptions.UserNotFoundException;
import com.wipro.microservice.hm.userservices.repositories.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public User addUser(@Valid User user) {
		return userRepository.save(user);
	}

	@Override
	public Long getNumberOfUsers() {
		return userRepository.countUsers();
	}
	
	
	@Override
	public User getUserById(Long id) {
	    return userRepository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	}

	@Override
	public Page<User> getUsersByState(String state, Pageable pageable) {
	    return userRepository.findByState(state, pageable);
	}

}
