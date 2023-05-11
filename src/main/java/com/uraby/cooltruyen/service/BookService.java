package com.uraby.cooltruyen.service;

import com.uraby.cooltruyen.dto.BookDTO;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    BookDTO getBook(Integer id);
    BookDTO updateBook(Integer id, BookDTO bookDTO);
    void deleteBook(Integer id);
}