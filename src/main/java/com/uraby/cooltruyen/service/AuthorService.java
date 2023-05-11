package com.uraby.cooltruyen.service;

import com.uraby.cooltruyen.dto.AuthorDTO;

public interface AuthorService {
	AuthorDTO createAuthor(AuthorDTO authorDTO);

	AuthorDTO getAuthor(int id);

	AuthorDTO updateAuthor(int id, AuthorDTO authorDTO);

	void deleteAuthor(int id);
}