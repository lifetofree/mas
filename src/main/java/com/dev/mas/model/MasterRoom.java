package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomreserved_m0_tbroom")
public class MasterRoom {
	
	@Id
	private long id;

	private int tridx;
	private String tridxDesc;
	private int tbidx;
	private String tbidxDesc;
	
	
	private String qty;
	private int cempIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private int trStatus;
	private String trStatusDesc;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}

	public int getTridx() {
		return tridx;
	}
	public void setTridx(int tridx) {
		this.tridx = tridx;
	}

	public String getTridxDesc() {
		return tridxDesc;
	}
	public void setTridxDesc(String tridxDesc) {
		this.tridxDesc = tridxDesc;
	}

	public int getTbidx() {
		return tbidx;
	}
	public void setTbidx(int tbidx) {
		this.tbidx = tbidx;
	}

	public String getTbidxDesc() {
		return tbidxDesc;
	}
	public void setTbidxDesc(String tbidxDesc) {
		this.tbidxDesc = tbidxDesc;
	}

	public int getCempIDX() {
		return cempIDX;
	}
	public void setCempIDX(int cempIDX) {
		this.cempIDX = cempIDX;
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
	public void setTcStatus(int trStatus) {
		this.trStatus = trStatus;
	}

	public String getTrStatusDesc() {
		return trStatusDesc;
	}

	public void setTcStatusDesc(String trStatusDesc) {
		this.trStatusDesc = trStatusDesc;
	}



@Override
public String toString() {
	return "MasterRoom [id=" + id + ", tridx=" +tridx + ",Tbidx=" + tbidx + ", qty=" +qty + ", CempIDX=" + cempIDX + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", trStatus=" + trStatus + ", trStatusDesc=" + trStatusDesc + "]";
}

}
