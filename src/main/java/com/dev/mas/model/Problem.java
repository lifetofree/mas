package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "U1_TbProblem")
public class Problem {

	@Id
	private long id;
	
	private int empidx;
	private String topic;
	private String context;
	private String tel;
	private int tsidx;
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date adCreateDate;
	private Date updateDate;
	private int tcStatus;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public Date getAdCreateDate() {
		return adCreateDate;
	}
	public void setAdCreateDate(Date adCreateDate) {
		this.adCreateDate = adCreateDate;
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
		return "Problem [id=" + id + ", Empidx=" + empidx + ", Topic=" + topic + ", Context=" + context + ",Tel=" + tel + ", Tsidx=" + tsidx + ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus + "]";
	}

}
