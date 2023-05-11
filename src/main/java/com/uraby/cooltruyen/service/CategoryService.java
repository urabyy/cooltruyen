package com.uraby.cooltruyen.service;

import com.uraby.cooltruyen.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO createCategory(CategoryDTO categoryDTO);

	CategoryDTO getCategory(Byte id);

	CategoryDTO updateCategory(Byte id, CategoryDTO categoryDTO);

	void deleteCategory(Byte id);
}