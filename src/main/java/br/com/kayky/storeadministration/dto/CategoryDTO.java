package br.com.kayky.storeadministration.dto;

public class CategoryDTO {
	private String description;
	public CategoryDTO() {

	}
	public CategoryDTO(String description) {
		super();
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
