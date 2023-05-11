package com.uraby.cooltruyen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uraby.cooltruyen.dto.BookDTO;
import com.uraby.cooltruyen.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
		BookDTO createdBook = bookService.createBook(bookDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Integer id) {
		BookDTO book = bookService.getBook(id);
		return ResponseEntity.ok(book);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
		BookDTO updatedBook = bookService.updateBook(id, bookDTO);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
}
