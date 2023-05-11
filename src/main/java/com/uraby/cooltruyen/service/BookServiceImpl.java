package com.uraby.cooltruyen.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.uraby.cooltruyen.dto.BookDTO;
import com.uraby.cooltruyen.entity.Book;
import com.uraby.cooltruyen.exception.NotFoundException;
import com.uraby.cooltruyen.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final ModelMapper modelMapper;

	public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BookDTO createBook(BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		Book savedBook = bookRepository.save(book);
		return modelMapper.map(savedBook, BookDTO.class);
	}

	@Override
	public BookDTO getBook(Integer id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
		return modelMapper.map(book, BookDTO.class);
	}

	@Override
	public BookDTO updateBook(Integer id, BookDTO bookDTO) {
		Book existingBook = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Book not found with id: " + id));

		modelMapper.map(bookDTO, existingBook);

		Book updatedBook = bookRepository.save(existingBook);
		return modelMapper.map(updatedBook, BookDTO.class);
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

}
