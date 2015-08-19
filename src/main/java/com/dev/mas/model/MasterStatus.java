package com.dev.mas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "CarBooking_M0_TbStatus")
public class MasterStatus {

	@Id
	private long id;
	
	private String statusTH;
	private String statusEN;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getStatusTH() {
		return statusTH;
	}


	public void setStatusTH(String statusTH) {
		this.statusTH = statusTH;
	}


	public String getStatusEN() {
		return statusEN;
	}


	public void setStatusEN(String statusEN) {
		this.statusEN = statusEN;
	}


	@Override
	public String toString() {
		return "MasterTypeCar [id=" + id + ", StatusEN=" + statusTH + ", StatusEN=" + statusEN + "]";
	}
	
}
