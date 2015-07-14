package com.dev.mas.model;

import java.sql.Time;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "U0_TbDetailRent")
public class CarBooking {

	@Id
	private long id;
	
	private int empidx;
	private int tridx;
	private int tcidx;
	private int tpidx;
	private Date datestart;
	private Date dateend;
	private Time timestart;
	private Time timeend;
	private String responsible;
	private String qty;
	private String objective;
	private int tsidx;
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private int tcStatus;
	private String change;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getEmpidx() {
		return empidx;
	}
	public void setEmpidx(int empidx) {
		this.empidx = empidx;
	}
	public int getTridx() {
		return tridx;
	}
	public void setTridx(int tridx) {
		this.tridx = tridx;
	}
	public int getTcidx() {
		return tcidx;
	}
	public void setTcidx(int tcidx) {
		this.tcidx = tcidx;
	}
	public int getTpidx() {
		return tpidx;
	}
	public void setTpidx(int tpidx) {
		this.tpidx = tpidx;
	}
	public Date getDatestart() {
		return datestart;
	}
	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}
	public Date getDateend() {
		return dateend;
	}
	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}
	public Time getTimestart() {
		return timestart;
	}
	public void setTimestart(Time timestart) {
		this.timestart = timestart;
	}
	public Time getTimeend() {
		return timeend;
	}
	public void setTimeend(Time timeend) {
		this.timeend = timeend;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public int getTsidx() {
		return tsidx;
	}
	public void setTsidx(int tsidx) {
		this.tsidx = tsidx;
	}
	public int getcEmpIDX() {
		return cEmpIDX;
	}
	public void setcEmpIDX(int cEmpIDX) {
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
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	
	
	@Override
	public String toString() {
		return "CarBooking [id=" + id + ", Empidx=" + empidx + ", Tridx=" + tridx + ", Tcidx=" + tcidx + ", Tpidx=" + tpidx + ", Datestart=" + datestart + ", Dateend=" + dateend + ", Timestart=" + timestart + ", Timeend=" + timeend + ", Responsible=" + responsible + ", Qty=" + qty + ", Objective=" + objective + ", Tsidx=" + tsidx + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + ", Change=" + change + "]";
	}	
	
	
	}

