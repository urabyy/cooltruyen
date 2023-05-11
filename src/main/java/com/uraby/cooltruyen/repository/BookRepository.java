package com.uraby.cooltruyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uraby.cooltruyen.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}