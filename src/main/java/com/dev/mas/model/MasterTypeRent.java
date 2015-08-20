package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CarBooking_M0_TbTypeRent") 
public class MasterTypeRent {
	@Id
	private long id;
	
	private String typerentTH;
	private String typerentEN;
	
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private int tcStatus;
	private String tcStatusDesc;

	public String getTcStatusDesc() {
		return tcStatusDesc;
	}

	public void setTcStatusDesc(String tcStatusDesc) {
		this.tcStatusDesc = tcStatusDesc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getTyperentTH() {
		return typerentTH;
	}

	public void setTyperentTH(String typerentTH) {
		this.typerentTH = typerentTH;
	}

	public String getTyperentEN() {
		return typerentEN;
	}

	public void setTyperentEN(String typerentEN) {
		this.typerentEN = typerentEN;
	}

	public int getcEmpIDX() {
		return cEmpIDX;
	}

	public void setcEmpIDX(int cEmpIDX) {
		this.cEmpIDX = cEmpIDX;
	}

	public int getCEmpIDX() {
		return cEmpIDX;
	}

	public void setCEmpIDX(int cEmpIDX) {
		this.cEmpIDX = cEmpIDX;
	}

	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getAdEmpIDX() {
		return adEmpIDX;
	}

	public void setAdEmpIDX(int adEmpIDX) {
		this.adEmpIDX = adEmpIDX;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getTcStatus() {
		return tcStatus;
	}

	public void setTcStatus(int tcStatus) {
		this.tcStatus = tcStatus;
	}

	

@Override
public String toString() {
	return "MasterTypeRent [id=" + id + ", TyperentTH=" +typerentTH + ",TyperentEN=" + typerentEN + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + "]";
}
}
