package com.aws_springboot.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws_springboot.mongodb.domain.User;
import com.aws_springboot.mongodb.dto.UserDTO;
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
	
	public User insert(User obj) {
		obj = repository.insert(obj);
		return obj;
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(String id, User obj) {
		User newObj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		updateData(obj, newObj);
		return repository.save(newObj);
	}
	
	private void updateData(User obj, User newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
	
}
