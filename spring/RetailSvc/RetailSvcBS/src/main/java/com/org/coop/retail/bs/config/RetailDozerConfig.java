package com.org.coop.retail.bs.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.org.coop.retail.bs.mapper.converter.RetailAddressCC;

@Configuration
@ComponentScan(value={"com.org.coop"})
public class RetailDozerConfig {
	
	@Bean(name = "org.dozer.retail.Mapper")
	  public DozerBeanMapper dozerBean() {
	    List mappingFiles = Arrays.asList(
	      "globalMapping.xml", 
	      "retailBranchMapping.xml",
	      "retailDocumentMapping.xml"
	    );
	
	    Map<String, CustomConverter> customConvertersWithId = new HashMap<String, CustomConverter>();
	    customConvertersWithId.put("retailAddressCC", getRetailAddressCC());
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    dozerBean.setMappingFiles(mappingFiles);
	    dozerBean.setCustomConvertersWithId(customConvertersWithId);
	    return dozerBean;
	  }
	
	@Bean
	public CustomConverter getRetailAddressCC() {
		CustomConverter cc = new RetailAddressCC();
		return cc;
	}
}
