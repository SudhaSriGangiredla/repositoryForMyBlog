package com.org.coop.canonical.retail.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.org.coop.canonical.account.beans.TransactionPaymentBean;

public class MaterialTranHrdBean {
	protected int tranId;
	protected int glTranId;
	protected int branchId;
	protected String branchName;
	protected int customerId;
	protected String customerName;
	protected int vendorId;
	protected String vendorName;
	protected BigDecimal billAmt;
	protected Date actionDate;
	protected String billNo;
	protected Date billDate;
	protected BigDecimal discount;
	protected Timestamp createDate;
	protected String createUser;
	protected String deleteInd;
	protected String deleteReason;
	protected BigDecimal grossTotal;
	protected BigDecimal outstandingAmt;
	protected BigDecimal paidAmt;
	protected String paidBy;
	protected String passingAuthInd;
	protected String passingAuthRemark;
	protected String tranNo;
	protected String tranType;
	protected Timestamp updateDate;
	protected String updateUser;
	protected BigDecimal vat;
	protected String remarks;
	
	protected List<MaterialTranDtlBean> materialTranDtls = new ArrayList<MaterialTranDtlBean>();
	protected TransactionPaymentBean payment;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tranId;
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
		MaterialTranHrdBean other = (MaterialTranHrdBean) obj;
		if (tranId != other.tranId)
			return false;
		return true;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(BigDecimal billAmt) {
		this.billAmt = billAmt;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
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

	public BigDecimal getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(BigDecimal grossTotal) {
		this.grossTotal = grossTotal;
	}

	public BigDecimal getOutstandingAmt() {
		return outstandingAmt;
	}

	public void setOutstandingAmt(BigDecimal outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}

	public BigDecimal getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(BigDecimal paidAmt) {
		this.paidAmt = paidAmt;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
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

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public List<MaterialTranDtlBean> getMaterialTranDtls() {
		return materialTranDtls;
	}

	public void setMaterialTranDtls(List<MaterialTranDtlBean> materialTranDtls) {
		this.materialTranDtls = materialTranDtls;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getGlTranId() {
		return glTranId;
	}

	public void setGlTranId(int glTranId) {
		this.glTranId = glTranId;
	}

	public TransactionPaymentBean getPayment() {
		return payment;
	}

	public void setPayment(TransactionPaymentBean payment) {
		this.payment = payment;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
