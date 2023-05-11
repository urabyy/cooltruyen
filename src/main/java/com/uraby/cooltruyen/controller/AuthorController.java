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

import com.uraby.cooltruyen.dto.AuthorDTO;
import com.uraby.cooltruyen.service.AuthorService;

@RestController
@RequestMapping("/api/tac-gia")
public class AuthorController {
	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping
	public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
		AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable int id) {
		AuthorDTO author = authorService.getAuthor(id);
		return ResponseEntity.ok(author);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO) {
		AuthorDTO updatedAuthor = authorService.updateAuthor(id, authorDTO);
		return ResponseEntity.ok(updatedAuthor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.noContent().build();
	}
}