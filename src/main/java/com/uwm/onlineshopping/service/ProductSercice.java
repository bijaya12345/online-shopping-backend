package com.uwm.onlineshopping.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.uwm.onlineshopping.dto.ProductDto;

public interface ProductSercice {

	void saveProduct(MultipartFile file, String title, String price, String description) throws IOException;

	void updateProduct(ProductDto productDto);

	void deleteProduct(Long id);

	ProductDto getProductById(Long id);

	List<ProductDto> getAllProduct();

}
