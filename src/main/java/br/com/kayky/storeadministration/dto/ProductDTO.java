package br.com.kayky.storeadministration.dto;

import br.com.kayky.storeadministration.entities.Category;

public class ProductDTO {
	private String name;
	private String description;
	private Double price;
	private Category category;

	public ProductDTO() {

	}

	public ProductDTO(String name, String description, Double price, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
