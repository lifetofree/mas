package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomreserved_m0_tbplace")
public class MasterPlaceReserved {
	
	@Id
	private long id;

	private String placeTH;
	
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private int trStatus;
	private String trStatusDesc;

	public String getTrStatusDesc() {
		return trStatusDesc;
	}

	public void setTrStatusDesc(String trStatusDesc) {
		this.trStatusDesc = trStatusDesc;
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

	public int getTrStatus() {
		return trStatus;
	}

	public void setTrStatus(int trStatus) {
		this.trStatus = trStatus;
	}


@Override
public String toString() {
	return "MasterPlaceReserved [id=" + id + ", placeTH=" +placeTH + ", createDate=" + createDate + ", adEmpIDX=" + adEmpIDX + ", updateDate=" + updateDate + ", tcStatus=" + trStatus + ", trStatusDesc=" + trStatusDesc + "]";
	}
}