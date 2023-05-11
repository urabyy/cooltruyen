package com.uraby.cooltruyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uraby.cooltruyen.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Byte> {
}