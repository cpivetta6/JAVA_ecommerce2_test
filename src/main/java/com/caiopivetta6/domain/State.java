package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class State implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	private List<City> cities;
	
	public State() {
		
	}

	public State(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		State other = (State) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
