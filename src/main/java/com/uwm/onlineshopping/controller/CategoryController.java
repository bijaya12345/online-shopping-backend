package com.uwm.onlineshopping.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.uwm.onlineshopping.dto.CategoryDto;
import com.uwm.onlineshopping.dto.ProductDto;
import com.uwm.onlineshopping.service.CategoryService;
import com.uwm.onlineshopping.service.ProductSercice;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("categories")
public class CategoryController {

	private final CategoryService categorySercice;

	@Autowired
	public CategoryController(CategoryService categorySercice) {
		this.categorySercice = categorySercice;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveCategory(@RequestBody CategoryDto categoryDto) {
		categorySercice.saveCategory(categoryDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("category has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateCategory(@RequestBody CategoryDto CategoryDto) {
		categorySercice.updateCategory(CategoryDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("category has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteCategory(@PathVariable Long id) {
		categorySercice.deleteCategory(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("category has  has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getCategory(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("category has been deleted successfully.")
				.addParam("category", categorySercice.getCategoryById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getCategory() {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("category has been retrieved successfully.")
				.addParam("categories", categorySercice.getAllCategory()), HttpStatus.OK);
	}

}
