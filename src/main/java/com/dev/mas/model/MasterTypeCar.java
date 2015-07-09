package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "M0_TbTypeCar") 
public class MasterTypeCar {
	@Id
	private long id;
	
	private String typeCarTH;
	private String typeCarEN;
	
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private String change;
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

	public String getTypeCarTH() {
		return typeCarTH;
	}

	public void setTypeCarTH(String typeCarTH) {
		this.typeCarTH = typeCarTH;
	}

	public String getTypeCarEN() {
		return typeCarEN;
	}

	public void setTypeCarEN(String typeCarEN) {
		this.typeCarEN = typeCarEN;
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

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public int getTcStatus() {
		return tcStatus;
	}

	public void setTcStatus(int tcStatus) {
		this.tcStatus = tcStatus;
	}

	

@Override
public String toString() {
	return "CarBooking [id=" + id + ", TypeCarTH=" + typeCarTH + ", TypeCarEN=" + typeCarEN + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", Change=" + change + ", TcStatus=" + tcStatus + "]";
}

}
