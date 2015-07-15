package com.dev.mas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "U0_TbDetailRent")
public class CarBooking {

	@Id
	private long id;

	private int empidx;
	private int tridx;
	private int tcidx;
	private int tpidx;
	private Date datestart;
	private Date dateend;
	private String timestart;
	private String timeend;
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
		return "CarBooking [id=" + id + ", Empidx=" + empidx + ", Tridx="
				+ tridx + ", Tcidx=" + tcidx + ", Tpidx=" + tpidx
				+ ", Datestart=" + datestart + ", Dateend=" + dateend
				+ ", Timestart=" + timestart + ", Timeend=" + timeend
				+ ", Responsible=" + responsible + ", Qty=" + qty
				+ ", Objective=" + objective + ", Tsidx=" + tsidx
				+ ", CreateDate=" + createDate + ", AdEmpIDX=" + adEmpIDX
				+ ", UpdateDate=" + updateDate + ", TcStatus=" + tcStatus
				+ ", Change=" + change + "]";
	}

	// MasterTypeRent
	@Document(collection = "M0_TbTypeRent")
	public class MasterTypeRent {
		@Id
		private long id;

		private String typerentTH;
		private String typerentEN;

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

		public String getTyperentTH() {
			return typerentTH;
		}

		public void setTyperentTH(String typerentTH) {
			this.typerentTH = typerentTH;
		}

		public String getTyperentEN() {
			return typerentEN;
		}

		public void setTyperentEN(String typerentEN) {
			this.typerentEN = typerentEN;
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
			return "CarBooking [id=" + id + ", TyperentTH=" + typerentTH
					+ ",TyperentEN=" + typerentEN + ", CreateDate="
					+ createDate + ", AdEmpIDX=" + adEmpIDX + ", UpdateDate="
					+ updateDate + ", TcStatus=" + tcStatus + "]";
		}
	}

	// MasterTypeCar
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

		public int getTcStatus() {
			return tcStatus;
		}

		public void setTcStatus(int tcStatus) {
			this.tcStatus = tcStatus;
		}

		@Override
		public String toString() {
			return "CarBooking [id=" + id + ", TypeCarTH=" + typeCarTH
					+ ", TypeCarEN=" + typeCarEN + ", CreateDate=" + createDate
					+ ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate
					+ ", TcStatus=" + tcStatus + "]";
		}
	}

	//MasterPlace
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
			return "CarBooking [id=" + id + ", PlaceTH=" + placeTH
					+ ",PlaceEN=" + placeEN + ", CreateDate=" + createDate
					+ ", AdEmpIDX=" + adEmpIDX + ", UpdateDate=" + updateDate
					+ ", TcStatus=" + tcStatus + "]";
		}
	}
}
