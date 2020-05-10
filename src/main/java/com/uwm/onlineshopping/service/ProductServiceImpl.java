package com.uwm.onlineshopping.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uwm.onlineshopping.dto.ProductDto;
import com.uwm.onlineshopping.model.ProductEntity;
import com.uwm.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductSercice {

	private final ProductRepository productRepository;
	private final FileService fileService;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, FileService fileService) {
		this.productRepository = productRepository;
		this.fileService = fileService;
	}

	@Override
	public void saveProduct(MultipartFile file, String title, String price, String description) throws IOException {

//		FileMetaData fileMetaData = fileService.storeData(file, description, description);
		ProductEntity productEntity = new ProductEntity();
		productEntity.setPrice(new BigDecimal(price));
//		productEntity.setImage(fileMetaData.getLocation());
		productEntity.setTitle(title);
		productEntity.setDescription(description);
		productEntity.setImg(file.getBytes());
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
		ProductEntity productEntity = productRepository.findById(id).get();
		BeanUtils.copyProperties(productEntity, productDto);
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
