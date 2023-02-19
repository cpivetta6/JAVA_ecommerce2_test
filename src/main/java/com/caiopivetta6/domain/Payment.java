package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.caiopivetta6.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment_tb")
public class Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Instant moment;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "order_id")
	@MapsId
	private Order order;
	
	public Payment() {
		
	}
	
	public Payment(Integer id, Instant moment) {
		super();
		this.id = id;
		this.moment = moment;
		
	}
	
	
	/*
	public OrderStatus getOrderStatus() {
		return OrderStatus.toEnum(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCod();
	}*/

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
