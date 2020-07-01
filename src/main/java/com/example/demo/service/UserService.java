package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;


public interface UserService {
  
  List<User> findAll();

	Optional<User> findOne(int id);

	void save(User user);
	
	void update(User user);
	
	void delete(int id);
}