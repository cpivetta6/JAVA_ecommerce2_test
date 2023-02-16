package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String square;
	private String street;
	private String number;
	private String zcode;
	
	private City city;
	
	private Client client;

	public Address(Integer id, String square, String street, String number, String zcode, City city, Client client) {
		super();
		this.id = id;
		this.square = square;
		this.street = street;
		this.number = number;
		this.zcode = zcode;
		this.city = city;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZcode() {
		return zcode;
	}

	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
