package com.uwm.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_tbl")
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String title;
	private double price;
	private String description;
	private String image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
