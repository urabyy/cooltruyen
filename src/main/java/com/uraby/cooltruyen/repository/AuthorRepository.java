package com.uraby.cooltruyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uraby.cooltruyen.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}