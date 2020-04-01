package com.uwm.onlineshopping.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.uwm.onlineshopping.model.ProductEntity;

public class CategoryDto extends BaseDto {

	private String categoryName;
	private String categoryDescription;
	@OneToMany
	private List<ProductEntity> products = new ArrayList<>();

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}