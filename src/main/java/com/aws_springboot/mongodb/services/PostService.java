package com.aws_springboot.mongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws_springboot.mongodb.domain.Post;
import com.aws_springboot.mongodb.repositories.PostRepository;
import com.aws_springboot.mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		return post;
	}

}
