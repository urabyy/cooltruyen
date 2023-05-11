package com.uraby.cooltruyen.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.uraby.cooltruyen.dto.CategoryDTO;
import com.uraby.cooltruyen.entity.Category;
import com.uraby.cooltruyen.exception.NotFoundException;
import com.uraby.cooltruyen.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		Category savedCategory = categoryRepository.save(category);
		return modelMapper.map(savedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategory(Byte id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
		return modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(Byte id, CategoryDTO categoryDTO) {
		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Category not found with id: " + id));

		modelMapper.map(categoryDTO, existingCategory);

		Category updatedCategory = categoryRepository.save(existingCategory);
		return modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Byte id) {
		categoryRepository.deleteById(id);
	}

}