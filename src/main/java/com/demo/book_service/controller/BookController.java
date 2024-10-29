package com.demo.book_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book_service.repository.BookRepository;
import com.demo.book_service.model.Book;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(this.bookRepo.findAll());
	}
	
	@GetMapping("/books/{bid}")
	public ResponseEntity<Book> getBookById(@PathVariable("bid") int bookId) {
		return ResponseEntity.ok(this.bookRepo.findById(bookId).get());
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.ok(this.bookRepo.save(book));
	}

	@GetMapping("/showBooks/{id1}")
	public ResponseEntity<List<Book>> showBooks(@PathVariable("id1") long id1)
	{
		return ResponseEntity.ok(this.bookRepo.findById1(id1));
	}
}
