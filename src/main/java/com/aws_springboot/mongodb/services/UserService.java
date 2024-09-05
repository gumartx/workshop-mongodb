package com.aws_springboot.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws_springboot.mongodb.domain.User;
import com.aws_springboot.mongodb.repositories.UserRepository;
import com.aws_springboot.mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		return user;
	}
	
}
