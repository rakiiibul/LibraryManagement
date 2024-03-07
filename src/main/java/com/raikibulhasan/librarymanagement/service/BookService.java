package com.raikibulhasan.librarymanagement.service;

import com.raikibulhasan.librarymanagement.model.Book;
import com.raikibulhasan.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookView {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void updateBook(String isbn, Book book) {
        Optional<Book>optionalBook=bookRepository.findById(isbn);

//        if(optionalBook.isPresent()){
//            Book dbupdat=optionalBook.get();
//            dbupdat.setTitle(book.getTitle());
//            dbupdat.setAuthor(book.getAuthor());
//            dbupdat.setGenre(book.getGenre());
//            dbupdat.setStatus(book.getStatus());
//            //
//        }

    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public void deleteBook(String  isbn) {
        bookRepository.deleteById(isbn);

    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);

    }
}
