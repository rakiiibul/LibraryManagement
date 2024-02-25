package com.raikibulhasan.librarymanagement.repository;

import com.raikibulhasan.librarymanagement.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface BookRepository extends MongoRepository<Book,String> {
}
