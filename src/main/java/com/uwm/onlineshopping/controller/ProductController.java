package com.uwm.onlineshopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uwm.onlineshopping.dto.ProductDto;
import com.uwm.onlineshopping.service.FileService;
import com.uwm.onlineshopping.service.ProductSercice;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	private final ProductSercice productSercice;

	@Autowired
	public ProductController(ProductSercice productSercice, FileService fileService) {
		this.productSercice = productSercice;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveProduct(@RequestParam("file") MultipartFile file,
			@RequestParam("title") String title, @RequestParam("price") String price,
			@RequestParam("description") String description) {
		try {
			productSercice.saveProduct(file, title, price, description);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Product has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateProduct(@RequestBody ProductDto productDto) {
		productSercice.updateProduct(productDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("product has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteProduct(@PathVariable Long id) {
		productSercice.deleteProduct(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("product has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getproduct(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("product has been retrieved successfully by id.")
				.addParam("product", productSercice.getProductById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getProduct() {
		List<ProductDto> productList = productSercice.getAllProduct();
		List<ProductDto> products = new ArrayList<>();
		for (ProductDto p : productList) {
			String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(p.getImg());
			p.setImage(b64);
			products.add(p);
		}
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Product has been retrieved successfully.")
				.addParam("products", products), HttpStatus.OK);
	}

}
