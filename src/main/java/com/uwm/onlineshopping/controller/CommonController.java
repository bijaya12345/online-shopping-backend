package com.uwm.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uwm.onlineshopping.dto.ProductDto;
import com.uwm.onlineshopping.service.FileService;
import com.uwm.onlineshopping.service.ProductSercice;
import com.uwm.onlineshopping.util.ServiceResponse;


@RestController
@RequestMapping("/products")
public class CommonController {

	private final ProductSercice productSercice;

	@Autowired
	public CommonController(ProductSercice productSercice, FileService fileService) {
		this.productSercice = productSercice;
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
