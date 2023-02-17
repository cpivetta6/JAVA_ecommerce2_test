package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.caiopivetta6.domain.enums.OrderStatus;

public class Order implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Instant moment;
	private OrderStatus orderStatus;
	
	private List<Payment> payments;
	private Client client;
	
	
	public Order () {
		
	}

	public Order(Integer id, Instant moment, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
	}
	
	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
