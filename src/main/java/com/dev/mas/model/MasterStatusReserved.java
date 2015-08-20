package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomreserved_m0_tbstatus")
public class MasterStatusReserved {
	
	@Id
	private long id;

	private String statusTH;
	private String statusEN;
	
	private Date createDate;
	
	private int trStatus;
	private String trStatusDesc;


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
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getTrStatus() {
		return trStatus;
	}

	public void setTrStatus(int trStatus) {
		this.trStatus = trStatus;
	}
	
	public String getTrStatusDesc() {
		return trStatusDesc;
	}

	public void setTrStatusDesc(String trStatusDesc) {
		this.trStatusDesc = trStatusDesc;
	}


	@Override
	public String toString() {
		return "MasterStatusReserved [id=" + id + ", statusTH=" + statusTH + ", createDate=" + createDate + ", tcStatus=" + trStatus + ", trStatusDesc=" + trStatusDesc + "]";
	}

}
