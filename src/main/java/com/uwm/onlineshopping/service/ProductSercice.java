package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.ProductDto;

public interface ProductSercice {
	void saveProduct(ProductDto productDto);

	void updateProduct(ProductDto productDto);

	void deleteProduct(Long id);

	ProductDto getProductById(Long id);

	List<ProductDto> getAllProduct();

}
