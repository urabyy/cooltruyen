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

import com.uraby.cooltruyen.dto.CategoryDTO;
import com.uraby.cooltruyen.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Byte id) {
		CategoryDTO category = categoryService.getCategory(id);
		return ResponseEntity.ok(category);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Byte id, @RequestBody CategoryDTO categoryDTO) {
		CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Byte id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}

}