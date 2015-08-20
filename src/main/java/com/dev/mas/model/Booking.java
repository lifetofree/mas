package com.dev.mas.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {
	private long id;
	
	private String name;
	private String domain;
	
	private String car;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", name=" + name + " , car=" + car + "]";
	}

	
}
