package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.ProductDto;
import com.uwm.onlineshopping.model.ProductEntity;
import com.uwm.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductSercice {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void saveProduct(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productDto, productEntity);
		productRepository.save(productEntity);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productDto, productEntity);
		productRepository.save(productEntity);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);

	}

	@Override
	public ProductDto getProductById(Long id) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(productRepository.findById(id), productDto);
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProduct() {
		return productRepository.findAll().stream().map(ProductEntity -> {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(ProductEntity, productDto);
			return productDto;
		}).collect(Collectors.toList());
	}

}
