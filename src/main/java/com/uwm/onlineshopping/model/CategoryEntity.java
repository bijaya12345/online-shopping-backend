package com.uwm.onlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_tbl")
public class CategoryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_description")
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
