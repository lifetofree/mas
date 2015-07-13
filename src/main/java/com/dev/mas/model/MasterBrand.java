package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "M0_TbBrand") 
public class MasterBrand {
	@Id
	private long id;
	
	private String brandTH;
	private String brandEN;
	
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

	
	public String getBrandTH() {
		return brandTH;
	}

	public void setBrandTH(String brandTH) {
		this.brandTH = brandTH;
	}

	public String getBrandEN() {
		return brandEN;
	}

	public void setBrandEN(String brandEN) {
		this.brandEN = brandEN;
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
	return "MasterTypeCar [id=" + id + ", BrandTH=" + brandTH + ", BrandEN=" + brandEN + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + "]";
}
}
