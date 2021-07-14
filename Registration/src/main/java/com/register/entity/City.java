package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	
	@Id
    @Column(name="city")
	private String city;
	
    @Column(name="status")
	private boolean status;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String city, boolean status) {
		super();
		this.city = city;
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "City [city=" + city + ", status=" + status + "]";
	}
    
    
}
