package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CarBooking_U0_TbDetailRent")
public class CarBooking {

	@Id
	private long id;

	private int empidx;
	private int departidx;
	private int tridx;
	private String tridxDesc;
	private int tcidx;
	private String tcidxDesc;
	private int tbidx;
	private String tbidxDesc;
	private int tpidx;
	private String tpidxDesc;
	private String etcplace;
	private int tdidx;
	private String tdidxDesc;
	private Date datestart;
	private String datestartDisplay;
	private Date dateend;
	private String dateendDisplay;
	private String timestart;
	private String timestartDisplay;
	private String timeend;
	private String timeendDisplay;
	private String responsible;
	private String qty;
	private String nametip;
	private String objective;
	private String tel;
	private int tsidx;
	private String tsidxDesc;
	private int tspidx;
	private String tspidxDesc;
	private int cEmpIDX;
	private Date createDate;
	private int adEmpIDX;
	private Date adCreateDate;
	private Date updateDate;
	private int tcStatus;
	private String tcStatusDesc;
	private String change;
	private String Carli;

	// TbProblem
	private String topic;
	private String context;
	private String telproblem;
	private int tbpidx;

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

	public String getTridxDesc() {
		return tridxDesc;
	}

	public void setTridxDesc(String tridxDesc) {
		this.tridxDesc = tridxDesc;
	}

	public String getTcidxDesc() {
		return tcidxDesc;
	}

	public void setTcidxDesc(String tcidxDesc) {
		this.tcidxDesc = tcidxDesc;
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

	public int getTdidx() {
		return tdidx;
	}

	public void setTdidx(int tdidx) {
		this.tdidx = tdidx;
	}

	public String getTdidxDesc() {
		return tdidxDesc;
	}

	public void setTdidxDesc(String tdidxDesc) {
		this.tdidxDesc = tdidxDesc;
	}

	public String getCarli() {
		return Carli;
	}

	public void setCarli(String carli) {
		Carli = carli;
	}

	public void setTbidxDesc(String tbidxDesc) {
		this.tbidxDesc = tbidxDesc;
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

	
	public String getDatestartDisplay() {
		return datestartDisplay;
	}

	public void setDatestartDisplay(String datestartDisplay) {
		this.datestartDisplay = datestartDisplay;
	}

	public String getDateendDisplay() {
		return dateendDisplay;
	}

	public void setDateendDisplay(String dateendDisplay) {
		this.dateendDisplay = dateendDisplay;
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

	public String getTimeendDisplay() {
		return timeendDisplay;
	}

	public void setTimeendDisplay(String timeendDisplay) {
		this.timeendDisplay = timeendDisplay;
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

	public String getTsidxDesc() {
		return tsidxDesc;
	}

	public void setTsidxDesc(String tsidxDesc) {
		this.tsidxDesc = tsidxDesc;
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

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getTcStatusDesc() {
		return tcStatusDesc;
	}

	public void setTcStatusDesc(String tcStatusDesc) {
		this.tcStatusDesc = tcStatusDesc;
	}

	// tb problem

	public int getTbpidx() {
		return tbpidx;
	}

	public void setTbpidx(int tbpidx) {
		this.tbpidx = tbpidx;
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

	public String getTelproblem() {
		return telproblem;
	}

	public void setTelproblem(String telproblem) {
		this.telproblem = telproblem;
	}

	public int getTspidx() {
		return tspidx;
	}

	public void setTspidx(int tspidx) {
		this.tspidx = tspidx;
	}

	public String getTspidxDesc() {
		return tspidxDesc;
	}

	public void setTspidxDesc(String tspidxDesc) {
		this.tspidxDesc = tspidxDesc;
	}

	// MasterTypeRent
	private MasterTypeRent mastertyperent;

	public MasterTypeRent getMastertyperent() {
		return mastertyperent;
	}

	public void setMastertyperent(MasterTypeRent mastertyperent) {
		this.mastertyperent = mastertyperent;
	}

	@Override
	public String toString() {
		return "CarBooking [id=" + id + ", Empidx=" + empidx + ", departidx="
				+ departidx + ", Tridx=" + tridx + ", Tcidx=" + tcidx
				+ ", Tpidx=" + tpidx + ", Etcname=" + etcplace + ", Datestart="
				+ datestart + ", Dateend=" + dateend + ", Timestart="
				+ timestart + ", Timeend=" + timeend + ", Responsible="
				+ responsible + ", Qty=" + qty + ", nametip=" + nametip
				+ ", Objective=" + objective + ", Carli=" + Carli + ", Tel="
				+ tel + ",, Tsidx=" + tsidx + ", CreateDate=" + createDate
				+ ", AdEmpIDX=" + adEmpIDX + ", AdCreateDate=" + adCreateDate
				+ ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus
				+ ", Change=" + change + "]";
	}

	// MasterTypeCar
	private MasterTypeCar mastertypecar;

	public MasterTypeCar getMastertypecar() {
		return mastertypecar;
	}

	public void setMastertypecar(MasterTypeCar mastertypecar) {
		this.mastertypecar = mastertypecar;
	}

	// MasterPlace
	private MasterPlace masterplace;

	public MasterPlace getMasterplace() {
		return masterplace;
	}

	public void setMasterplace(MasterPlace masterplace) {
		this.masterplace = masterplace;
	}

	// MasterDataCar
	private MasterDataCar masterdatacar;

	public MasterDataCar getMasterdatacar() {
		return masterdatacar;
	}

	public void setMasterdatacar(MasterDataCar masterdatacar) {
		this.masterdatacar = masterdatacar;
	}

	// MasterBrand
	private MasterBrand masterbrand;

	public MasterBrand getMasterbrand() {
		return masterbrand;
	}

	public void setMasterbrand(MasterBrand masterbrand) {
		this.masterbrand = masterbrand;
	}

	// Problem
	private Problem problem;

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

}
