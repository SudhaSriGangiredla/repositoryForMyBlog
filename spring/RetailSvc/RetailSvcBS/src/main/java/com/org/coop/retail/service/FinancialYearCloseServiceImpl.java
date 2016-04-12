package com.org.coop.retail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.coop.canonical.beans.UIModel;
import com.org.coop.retail.servicehelper.FinancialYearCloseServiceHelperImpl;

@Service
public class FinancialYearCloseServiceImpl {

	private static final Logger log = Logger.getLogger(FinancialYearCloseServiceImpl.class); 
	
	@Autowired
	private FinancialYearCloseServiceHelperImpl financialYearCloseServiceHelperImpl;
	
	
	public boolean isFinancialYearClosed(int branchId, String financialYear) {
		return financialYearCloseServiceHelperImpl.isFinancialYearClosed(branchId, financialYear);
	}
	
	public UIModel saveFinancialYearData(UIModel uiModel) {
		
		return financialYearCloseServiceHelperImpl.saveFinancialYearData(uiModel);
	}
}
