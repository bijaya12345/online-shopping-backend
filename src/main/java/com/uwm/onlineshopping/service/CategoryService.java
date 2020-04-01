package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.CategoryDto;
import com.uwm.onlineshopping.dto.ProductDto;

public interface CategoryService {
	
	void saveCategory(CategoryDto categoryDto);

	void updateCategory(CategoryDto categoryDto);

	void deleteCategory(Long id);

	CategoryDto getCategoryById(Long id);

	List<CategoryDto> getAllCategory();

}
