package com.raikibulhasan.librarymanagement.service;

import com.raikibulhasan.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface BookView {

    Book addBook(Book book);
    void updateBook(String isbn,Book book);
    Iterable<Book> getBooks();
    Optional <Book> getBookById(String isbn);


    void deleteBook(String isbn);
}
