package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.CategoryDto;
import com.uwm.onlineshopping.model.CategoryEntity;
import com.uwm.onlineshopping.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void saveCategory(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryDto, categoryEntity);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryDto, categoryEntity);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);

	}

	@Override
	public CategoryDto getCategoryById(Long id) {
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(categoryRepository.findById(id), categoryDto);
		return categoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		return categoryRepository.findAll().stream().map(CategoryEntity -> {
			CategoryDto categoryDto = new CategoryDto();
			BeanUtils.copyProperties(CategoryEntity, categoryDto);
			return categoryDto;
		}).collect(Collectors.toList());
	}
}
