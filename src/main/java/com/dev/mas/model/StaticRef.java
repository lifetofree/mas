package com.dev.mas.model;

public class StaticRef {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDataRef(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", name=" + name + "]";
	}

	
}
