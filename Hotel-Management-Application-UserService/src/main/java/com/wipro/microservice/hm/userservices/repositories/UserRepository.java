package com.wipro.microservice.hm.userservices.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.microservice.hm.userservices.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	
	@Query("SELECT COUNT(u) FROM User u")
    Long countUsers();

	List<User> findByState(String state);

	Page<User> findByState(String state, Pageable pageable);

}
