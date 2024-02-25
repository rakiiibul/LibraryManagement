package com.raikibulhasan.librarymanagement;

import com.raikibulhasan.librarymanagement.repository.BookRepository;
import com.raikibulhasan.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
