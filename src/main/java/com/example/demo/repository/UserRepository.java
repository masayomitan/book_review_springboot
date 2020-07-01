package com.example.demo.repository;

// import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;



public interface UserRepository {

  // List<User> findAll();

	Optional<User> findOne(int id);

	void save(User user);
	
	int update(User user);
	
	int delete(int id);
  
}
