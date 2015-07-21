package com.dev.mas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class MIS_DomainHosting {

	@Document(collection="m0_mis_domainlist")
	public class m0_mis_domainlist {
		@Id
		private long id;
		
		private String domain;
		private int status;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
	}
	
	@Document(collection="u0_mis_domainlist")
	public class u0_mis_domainlist {
		@Id
		private long id;
		
		private int domainId;
		private String domainName;
		private String supplierId;
		private int paymentStatus;
		private int domainStatus;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public int getDomainId() {
			return domainId;
		}
		public void setDomainId(int domainId) {
			this.domainId = domainId;
		}
		public String getDomainName() {
			return domainName;
		}
		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}
		public String getSupplierId() {
			return supplierId;
		}
		public void setSupplierId(String supplierId) {
			this.supplierId = supplierId;
		}
		public int getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(int paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public int getDomainStatus() {
			return domainStatus;
		}
		public void setDomainStatus(int domainStatus) {
			this.domainStatus = domainStatus;
		}
		
	}
	
}
