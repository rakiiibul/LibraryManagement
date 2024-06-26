package com.raikibulhasan.librarymanagement.repository;

import com.raikibulhasan.librarymanagement.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface  BookRepository extends MongoRepository<Book,String> {

    List<Book> findByTitleContaining(String title);
}
