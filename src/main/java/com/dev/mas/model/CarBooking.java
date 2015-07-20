package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "U0_TbDetailRent")
public class CarBooking {

	@Id
	private long id;

	private int empidx;
	private int departidx;
	private int tridx;
	private int tcidx;
	private int tpidx;
	private String tpidxDesc;
	private String etcplace;
	private Date datestart;
	private Date dateend;
	private String timestart;
	private String timestartDisplay;
	private String timeend;
	private String responsible;
	private String qty;
	private String nametip;
	private String objective;
	private String tel;
	private int tsidx;
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date updateDate;
	private int tcStatus;
	private String change;

	public String getTimestartDisplay() {
		return timestartDisplay;
	}

	public void setTimestartDisplay(String timestartDisplay) {
		this.timestartDisplay = timestartDisplay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTpidxDesc() {
		return tpidxDesc;
	}

	public void setTpidxDesc(String tpidxDesc) {
		this.tpidxDesc = tpidxDesc;
	}

	public int getEmpidx() {
		return empidx;
	}

	public void setEmpidx(int empidx) {
		this.empidx = empidx;
	}

	
	public int getDepartidx() {
		return departidx;
	}

	public void setDepartidx(int departidx) {
		this.departidx = departidx;
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

	public String getEtcplace() {
		return etcplace;
	}

	public void setEtcplace(String etcplace) {
		this.etcplace = etcplace;
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

	public String getTimestart() {
		return timestart;
	}

	public void setTimestart(String timestart) {
		this.timestart = timestart;
	}

	public String getTimeend() {
		return timeend;
	}

	public void setTimeend(String timeend) {
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
	
	

	public String getNametip() {
		return nametip;
	}

	public void setNametip(String nametip) {
		this.nametip = nametip;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
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
		return "CarBooking [id=" + id + ", Empidx=" + empidx + ", departidx="
				+ departidx + ", Tridx=" + tridx + ", Tcidx=" + tcidx + ", Tpidx=" + tpidx
				+ ", Etcname=" + etcplace + ", Datestart=" + datestart + ", Dateend=" + dateend
				+ ", Timestart=" + timestart + ", Timeend=" + timeend
				+ ", Responsible=" + responsible + ", Qty=" + qty + ", nametip=" + nametip 
				+ ", Objective=" + objective + ", Tel=" + tel 
				+ ",, Tsidx=" + tsidx 
				+ ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX
				+ ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus
				+ ", Change=" + change + "]";
	}
	
	//MasterTypeRent
	private MasterTypeRent mastertyperent;
	
	public MasterTypeRent getMastertyperent() {
		return mastertyperent;
	}

	public void setMastertyperent(MasterTypeRent mastertyperent) {
		this.mastertyperent = mastertyperent;
	}


	// MasterTypeCar
	private MasterTypeCar mastertypecar;
	
	public MasterTypeCar getMastertypecar() {
		return mastertypecar;
	}

	public void setMastertypecar(MasterTypeCar mastertypecar) {
		this.mastertypecar = mastertypecar;
	}

	
	//MasterPlace
	private MasterPlace masterplace;
	
	
	public MasterPlace getMasterplace() {
		return masterplace;
	}

	public void setMasterplace(MasterPlace masterplace) {
		this.masterplace = masterplace;
	}
}
