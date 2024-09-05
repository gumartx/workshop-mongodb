package com.aws_springboot.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aws_springboot.mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
