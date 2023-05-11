package com.uraby.cooltruyen.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uraby.cooltruyen.dto.AuthorDTO;
import com.uraby.cooltruyen.dto.BookDTO;
import com.uraby.cooltruyen.dto.CategoryDTO;
import com.uraby.cooltruyen.entity.Author;
import com.uraby.cooltruyen.entity.Book;
import com.uraby.cooltruyen.entity.Category;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(Book.class, BookDTO.class)
		.addMapping(Book::getTitle, BookDTO::setTitle);

		modelMapper.createTypeMap(BookDTO.class, Book.class)
		.addMapping(BookDTO::getTitle, Book::setTitle);

		modelMapper.createTypeMap(Author.class, AuthorDTO.class)
		.addMapping(Author::getName, AuthorDTO::setName);

		modelMapper.createTypeMap(AuthorDTO.class, Author.class)
		.addMapping(AuthorDTO::getName, Author::setName);

		modelMapper.createTypeMap(Category.class, CategoryDTO.class)
		.addMapping(Category::getCategory,CategoryDTO::setCategory);

		modelMapper.createTypeMap(CategoryDTO.class, Category.class)
		.addMapping(CategoryDTO::getCategory, Category::setCategory);
		return modelMapper;
	}
}