package com.org.coop.retail.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;


/**
 * The persistent class for the retail_gl_ledger database table.
 * 
 */
@Entity
@Table(name="retail_gl_ledger")
@NamedQuery(name="RetailGlLedger.findAll", query="SELECT r FROM RetailGlLedger r")
@SQLDelete(sql="update retail_gl_ledger set delete_ind='Y' where retail_gl_tran_id = ?")
@Where(clause="delete_ind is NULL")
public class RetailGlLedger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="retail_gl_tran_id")
	private int retailGlTranId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="delete_ind")
	private String deleteInd;

	@Column(name="delete_reason")
	private String deleteReason;

	@Column(name="passing_auth_ind")
	private String passingAuthInd;

	@Column(name="passing_auth_remark")
	private String passingAuthRemark;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to GlLedgerHrd
	@ManyToOne
	@JoinColumn(name="gl_tran_id")
	private GlLedgerHrd glLedgerHrd;

	//bi-directional many-to-one association to MaterialTranHrd
	@ManyToOne
	@JoinColumn(name="tran_id")
	private MaterialTranHrd materialTranHrd;

	public RetailGlLedger() {
	}

	public int getRetailGlTranId() {
		return this.retailGlTranId;
	}

	public void setRetailGlTranId(int retailGlTranId) {
		this.retailGlTranId = retailGlTranId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getPassingAuthInd() {
		return this.passingAuthInd;
	}

	public void setPassingAuthInd(String passingAuthInd) {
		this.passingAuthInd = passingAuthInd;
	}

	public String getPassingAuthRemark() {
		return this.passingAuthRemark;
	}

	public void setPassingAuthRemark(String passingAuthRemark) {
		this.passingAuthRemark = passingAuthRemark;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public GlLedgerHrd getGlLedgerHrd() {
		return this.glLedgerHrd;
	}

	public void setGlLedgerHrd(GlLedgerHrd glLedgerHrd) {
		this.glLedgerHrd = glLedgerHrd;
	}

	public MaterialTranHrd getMaterialTranHrd() {
		return this.materialTranHrd;
	}

	public void setMaterialTranHrd(MaterialTranHrd materialTranHrd) {
		this.materialTranHrd = materialTranHrd;
	}
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		long currentTime = System.currentTimeMillis();
	    updateDate = new Timestamp(currentTime);
	    if (createDate == null) {
	    	createDate = new Timestamp(currentTime);
	    }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + retailGlTranId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetailGlLedger other = (RetailGlLedger) obj;
		if (retailGlTranId != other.retailGlTranId)
			return false;
		return true;
	}
}