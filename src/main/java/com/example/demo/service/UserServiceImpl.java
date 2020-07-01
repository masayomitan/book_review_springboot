package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;

  @Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
  }

  @Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
  
	@Override
	public  Optional<User> findOne(int id) {
		return userRepository.findOne(id);
	}
  
  
  @Override
	public void save(User user) {
		userRepository.save(user);
  }
  
  @Override
	public void update(User user) {
		userRepository.save(user);
		}

  public void delete(int id) {
    userRepository.delete(id);
  }

}
  