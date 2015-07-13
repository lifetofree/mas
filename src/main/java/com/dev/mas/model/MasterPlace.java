package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "M0_TbPlace") 
public class MasterPlace {
	@Id
	private long id;
	
	private String placeTH;
	private String placeEN;
	
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

	
	
	public String getPlaceTH() {
		return placeTH;
	}

	public void setPlaceTH(String placeTH) {
		this.placeTH = placeTH;
	}

	public String getPlaceEN() {
		return placeEN;
	}

	public void setPlaceEN(String placeEN) {
		this.placeEN = placeEN;
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
	return "MasterTypeCar [id=" + id + ", PlaceTH=" +placeTH + ",PlaceEN=" + placeEN + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + "]";
}
}
