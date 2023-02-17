package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.caiopivetta6.domain.enums.CategoryName;

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private CategoryName categoryName;
	
	private List<Product> products;

	public Category(Integer id, CategoryName categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryName getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(CategoryName categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
