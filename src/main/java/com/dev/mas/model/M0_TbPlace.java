package com.dev.mas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "m0_tbplace")
public class M0_TbPlace {
	
	@Id
	private long id;
	
	private int tridx;

	private String name;
	private String domain;
	private String supplier;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getTridx() {
		return tridx;
	}

	public void setTridx(int tridx) {
		this.tridx = tridx;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public String toString() {
		return "M0_TbPlace [id=" + id + ", tridx=" + tridx + ", name=" + name + ", domain=" + domain + "]";
	}

}
