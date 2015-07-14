package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="M0_TbStatus")
public class MasterStatus {
	
	@Id
	private long id;
	private String statusTH;
	private String statusEN;
	
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
	return "MasterTypeCar [id=" + id + ", StatusTH=" +statusTH + ",StatusEN=" + statusEN + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + "]";
}
}
