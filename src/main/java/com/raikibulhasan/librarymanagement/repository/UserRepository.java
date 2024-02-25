package com.raikibulhasan.librarymanagement.repository;

import com.raikibulhasan.librarymanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
