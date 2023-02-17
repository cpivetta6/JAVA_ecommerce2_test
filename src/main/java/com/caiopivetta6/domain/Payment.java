package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.caiopivetta6.domain.enums.OrderStatus;

public class Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Instant moment;
	
	private Order order;
	private Integer orderStatus;
	
	public Payment() {
		
	}
	
	public Payment(Integer id, Instant moment, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus.getCod();
	}
	
	
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.toEnum(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCod();
	}

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
