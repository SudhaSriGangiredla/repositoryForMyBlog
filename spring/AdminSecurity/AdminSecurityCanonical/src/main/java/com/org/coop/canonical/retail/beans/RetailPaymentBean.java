package com.org.coop.canonical.retail.beans;

import java.io.Serializable;
import java.util.Date;


public class RetailPaymentBean implements Serializable {
	protected static final long serialVersionUID = 1L;
	
	protected int retailPaymentId;
	protected int tranId;
	protected int paymentId;
	protected Date actionDate;
	protected Date createDate;
	protected String createUser;
	protected String deleteInd;
	protected String deleteReason;
	protected String passingAuthInd;
	protected String passingAuthRemark;
	protected Date updateDate;
	protected String updateUser;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + retailPaymentId;
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
		RetailPaymentBean other = (RetailPaymentBean) obj;
		if (retailPaymentId != other.retailPaymentId)
			return false;
		return true;
	}
	public int getRetailPaymentId() {
		return retailPaymentId;
	}
	public void setRetailPaymentId(int retailPaymentId) {
		this.retailPaymentId = retailPaymentId;
	}
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	public String getPassingAuthInd() {
		return passingAuthInd;
	}
	public void setPassingAuthInd(String passingAuthInd) {
		this.passingAuthInd = passingAuthInd;
	}
	public String getPassingAuthRemark() {
		return passingAuthRemark;
	}
	public void setPassingAuthRemark(String passingAuthRemark) {
		this.passingAuthRemark = passingAuthRemark;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}