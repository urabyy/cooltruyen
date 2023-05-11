package com.uraby.cooltruyen.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.uraby.cooltruyen.dto.AuthorDTO;
import com.uraby.cooltruyen.entity.Author;
import com.uraby.cooltruyen.exception.NotFoundException;
import com.uraby.cooltruyen.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {
	private final AuthorRepository authorRepository;
	private final ModelMapper modelMapper;

	public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
		this.authorRepository = authorRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public AuthorDTO createAuthor(AuthorDTO authorDTO) {
		Author author = modelMapper.map(authorDTO, Author.class);
		Author savedAuthor = authorRepository.save(author);
		return modelMapper.map(savedAuthor, AuthorDTO.class);
	}

	@Override
	public AuthorDTO getAuthor(int id) {
		Author author = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Author not found with id: " + id));
		return modelMapper.map(author, AuthorDTO.class);
	}

	@Override
	@Transactional
	public AuthorDTO updateAuthor(int id, AuthorDTO authorDTO) {
		Author existingAuthor = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Author not found with id: " + id));
		System.out.println(authorDTO.toString());
		
		modelMapper.map(authorDTO, existingAuthor);
		System.out.println(existingAuthor.toString());

		Author updatedAuthor = authorRepository.save(existingAuthor);
		System.out.println(id);
		System.out.println(existingAuthor.toString());
		return modelMapper.map(updatedAuthor, AuthorDTO.class);
	}

	@Override
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}
}