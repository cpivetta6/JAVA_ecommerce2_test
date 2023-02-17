package com.caiopivetta6.domain.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);
	
	private Integer cod;
	
	private OrderStatus(Integer cod) {
		this.cod = cod;
	}
	
	public static OrderStatus toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(OrderStatus x : OrderStatus.values()) {
			if(cod == x.getCod()) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("invalid code: " + cod);
		
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	
	
}
