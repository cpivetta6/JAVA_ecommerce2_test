package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Product product, Order order, Integer quantity, Double price) {
		super();
		id.setProduct(product);
		id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
		
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	

	public OrderItemPk getId() {
		return id;
	}

	public void setId(OrderItemPk id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
