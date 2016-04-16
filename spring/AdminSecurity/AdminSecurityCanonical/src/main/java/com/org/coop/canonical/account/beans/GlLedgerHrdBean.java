package com.org.coop.canonical.account.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.org.coop.canonical.retail.beans.RetailGlLedgerBean;


public class GlLedgerHrdBean implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected int glTranId;
	protected Date actionDate;
	protected Date createDate;
	protected String createUser;
	protected String deleteInd;
	protected String deleteReason;
	protected String fy;
	protected String passingAuthInd;
	protected String passingAuthRemark;
	protected String tranNo;
	protected String tranType;
	protected Date updateDate;
	protected String updateUser;

	protected List<CardRegisterBean> cardRegisters = new ArrayList<CardRegisterBean>();
	protected List<ChequeRegisterBean> chequeRegisters = new ArrayList<ChequeRegisterBean>();
	protected List<CreditPaymentBean> creditPayments = new ArrayList<CreditPaymentBean>();
	protected List<LoanPaymentBean> loanPayments = new ArrayList<LoanPaymentBean>();
	protected List<RetailGlLedgerBean> retailGlLedgers = new ArrayList<RetailGlLedgerBean>();
	protected List<TransactionPaymentBean> transactionPayments = new ArrayList<TransactionPaymentBean>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + glTranId;
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
		GlLedgerHrdBean other = (GlLedgerHrdBean) obj;
		if (glTranId != other.glTranId)
			return false;
		return true;
	}
	public int getGlTranId() {
		return glTranId;
	}
	public void setGlTranId(int glTranId) {
		this.glTranId = glTranId;
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
	public String getFy() {
		return fy;
	}
	public void setFy(String fy) {
		this.fy = fy;
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
	public String getTranNo() {
		return tranNo;
	}
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
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
	public List<CardRegisterBean> getCardRegisters() {
		return cardRegisters;
	}
	public void setCardRegisters(List<CardRegisterBean> cardRegisters) {
		this.cardRegisters = cardRegisters;
	}
	public List<ChequeRegisterBean> getChequeRegisters() {
		return chequeRegisters;
	}
	public void setChequeRegisters(List<ChequeRegisterBean> chequeRegisters) {
		this.chequeRegisters = chequeRegisters;
	}
	public List<CreditPaymentBean> getCreditPayments() {
		return creditPayments;
	}
	public void setCreditPayments(List<CreditPaymentBean> creditPayments) {
		this.creditPayments = creditPayments;
	}
	public List<LoanPaymentBean> getLoanPayments() {
		return loanPayments;
	}
	public void setLoanPayments(List<LoanPaymentBean> loanPayments) {
		this.loanPayments = loanPayments;
	}
	public List<RetailGlLedgerBean> getRetailGlLedgers() {
		return retailGlLedgers;
	}
	public void setRetailGlLedgers(List<RetailGlLedgerBean> retailGlLedgers) {
		this.retailGlLedgers = retailGlLedgers;
	}
	public List<TransactionPaymentBean> getTransactionPayments() {
		return transactionPayments;
	}
	public void setTransactionPayments(List<TransactionPaymentBean> transactionPayments) {
		this.transactionPayments = transactionPayments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}