package com.org.coop.retail.bs.mapper.converter;

import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.coop.canonical.retail.beans.MaterialTranHrdBean;
import com.org.coop.retail.entities.BranchMaster;
import com.org.coop.retail.entities.MaterialTranHrd;
import com.org.coop.retail.entities.RetailCustomerMaster;
import com.org.coop.retail.repositories.RetailBranchMasterRepository;
import com.org.coop.retail.repositories.RetailCustomerMasterRepository;
import com.org.coop.retail.repositories.RetailVendorMasterRepository;

@Component("retailMaterialTranHrdCC")
public class RetailMaterialTranHrdCC extends DozerConverter<MaterialTranHrdBean, MaterialTranHrd> implements MapperAware, CustomConverter {
	@Autowired
	private RetailBranchMasterRepository retailBranchMasterRepository;
	
	@Autowired
	private RetailCustomerMasterRepository retailCustomerMasterRepository;
	
	@Autowired
	private RetailVendorMasterRepository retailVendorMasterRepository;
	
	public RetailMaterialTranHrdCC() {
		super(MaterialTranHrdBean.class, MaterialTranHrd.class);
	}
	
	public RetailMaterialTranHrdCC(Class prototypeA, Class prototypeB) {
		super(prototypeA, prototypeB);
	}
	
	public void setMapper(Mapper arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MaterialTranHrdBean convertFrom(MaterialTranHrd src, MaterialTranHrdBean dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialTranHrd convertTo(MaterialTranHrdBean src, MaterialTranHrd dest) {
		// TODO Auto-generated method stub
		if(src != null) {
			BranchMaster branch = retailBranchMasterRepository.findOne(src.getBranchId());
//			RetailCustomerMaster customer = retailCustomerMasterRepository.findOne(src.getCustomerId());
			
			dest.setBranchMaster(branch);
//			dest.setRetailCustomerMaster(customer);
		}
		return dest;
	}
}
