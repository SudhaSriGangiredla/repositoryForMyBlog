package com.org.test.coop.master.junit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.coop.admin.service.MasterDataSetupServiceImpl;
import com.org.coop.bs.config.DozerConfig;
import com.org.coop.canonical.master.beans.MasterDataBean;
import com.org.coop.canonical.master.beans.ModuleMasterBean;
import com.org.coop.canonical.master.beans.RuleMasterBean;
import com.org.coop.canonical.master.beans.RuleMasterValuesBean;
import com.org.test.coop.junit.JunitTestUtil;
import com.org.test.coop.society.data.transaction.config.TestDataAppConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.org.test.coop")
@ContextHierarchy({
	  @ContextConfiguration(classes={TestDataAppConfig.class, DozerConfig.class})
})
//@SpringApplicationConfiguration(classes={TestDataAppConfig.class, DozerConfig.class})
public class ModuleTest {
	private static final Logger logger = Logger.getLogger(ModuleTest.class);
	private MasterDataBean createModuleBean;
	private MasterDataBean createAnotherModuleBean;
	private MasterDataBean updateModuleBean;
	private MasterDataBean moduleRulePermBean;
	private MasterDataBean createModuleRuleValueBean;
	
	
	private String createModuleJson = null;
	private String createAnotherModuleJson = null;
	private String updateModuleJson = null;
	private String moduleRulePermJson = null;
	private String createModuleRuleValueJson = null;
	
	private ObjectMapper om = null;
	
	@Autowired
	private MasterDataSetupServiceImpl masterDataSetupServiceImpl;
	
	@Before
	public void runBefore() {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			om = new ObjectMapper();
			om.setSerializationInclusion(Include.NON_NULL);
			om.setDateFormat(df);
			createModuleJson = JunitTestUtil.getFileContent("inputJson/master/module/createModule.json");
			createModuleBean = om.readValue(createModuleJson, MasterDataBean.class);
			
			
			updateModuleJson = JunitTestUtil.getFileContent("inputJson/master/module/updateModule.json");
			updateModuleBean = om.readValue(updateModuleJson, MasterDataBean.class);
			
			moduleRulePermJson = JunitTestUtil.getFileContent("inputJson/master/module/createPermissionAndRule.json");
			moduleRulePermBean = om.readValue(moduleRulePermJson, MasterDataBean.class);
			
			createAnotherModuleJson = JunitTestUtil.getFileContent("inputJson/master/module/createAnotherModule.json");
			createAnotherModuleBean = om.readValue(createAnotherModuleJson, MasterDataBean.class);
			
			createModuleRuleValueJson = JunitTestUtil.getFileContent("inputJson/master/module/createModuleRuleValue.json");
			createModuleRuleValueBean = om.readValue(createModuleRuleValueJson, MasterDataBean.class);
			
		} catch (Exception e) {
			logger.error("Error while initializing: ", e);
		}
	}
	@Test
	public void testModule() {
		createModule();
		createDuplicateModule();
		updateModule();
		getValidModule();
		getNonExistanceModule();
		createModuleRuleAndPermission();
		createAnotherModule();
		getAllModules();
		createModuleRuleValues();
	}

	private void createModule() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(createModuleBean);
			
			String srcJson = om.writeValueAsString(moduleBean);
			moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions(((ModuleMasterBean)createModuleBean.getModules().toArray()[0]).getModuleName());
			String destJson = om.writeValueAsString(moduleBean);
			
			assertEquals(srcJson, destJson);
			
		} catch (Exception e) {
			logger.error("Error while creating module/duplicate module: ", e);
			Assert.fail("Error while creating module/duplicate module:");
		}
	}
	
	private void createAnotherModule() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(createAnotherModuleBean);
			
			String srcJson = om.writeValueAsString(moduleBean);
			moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions(((ModuleMasterBean)createAnotherModuleBean.getModules().toArray()[0]).getModuleName());
			String destJson = om.writeValueAsString(moduleBean);
			
			assertEquals(srcJson, destJson);
			
		} catch (Exception e) {
			logger.error("Error while creating module/duplicate module: ", e);
			Assert.fail("Error while creating module/duplicate module:");
		}
	}
	
	private void updateModule() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(updateModuleBean);

			String srcJson = om.writeValueAsString(moduleBean);
			moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions(((ModuleMasterBean)updateModuleBean.getModules().toArray()[0]).getModuleName());
			String destJson = om.writeValueAsString(moduleBean);
			
			assertEquals(srcJson, destJson);
		} catch (Exception e) {
			logger.error("Error while creating module: ", e);
			Assert.fail("Error while creating module:");
		}
	}
	
	private void createDuplicateModule() {
		try {
			// Create duplicate module 
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(createModuleBean);
			assertNotEquals(moduleBean.getErrorMsg(), null);
		} catch (Exception e) {
			logger.error("Error while creating module: ", e);
			Assert.fail("Error while creating module:");
		}
	}
	
	private void getValidModule() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions("RD");
			assertEquals(moduleBean.getErrorMsg(), null);
		} catch (Exception e) {
			logger.error("Error while validating module: ", e);
			Assert.fail("Error while validating module:");
		}
	}
	
	private void getNonExistanceModule() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions("RD1");
			assertNotEquals(moduleBean.getErrorMsg(), null);
		} catch (Exception e) {
			logger.error("Error while validating non existance module: ", e);
			Assert.fail("Error while validating non existance module:");
		}
	}
	
	private void createModuleRuleAndPermission() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(moduleRulePermBean);
			
			String srcJson = om.writeValueAsString(moduleBean);
			moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions(((ModuleMasterBean)moduleRulePermBean.getModules().toArray()[0]).getModuleName());
			String destJson = om.writeValueAsString(moduleBean);
			
			assertEquals(srcJson, destJson);
		} catch (Exception e) {
			logger.error("Error while creating module rules and permission: ", e);
			Assert.fail("Error while creating module rules and permission:");
		}
	}
	
	private void getAllModules() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.getModuleRulesAndPermissions("");
			assertEquals(moduleBean.getModules().size(), 2);
		} catch (Exception e) {
			logger.error("Error while Retriving module: ", e);
			Assert.fail("Error while Retriving module:");
		}
	}
	
	private void createModuleRuleValues() {
		try {
			MasterDataBean moduleBean = masterDataSetupServiceImpl.saveModuleRulesAndPermissions(createModuleRuleValueBean);
			RuleMasterValuesBean ruleVal = ((RuleMasterValuesBean)((RuleMasterBean)((ModuleMasterBean)moduleBean.getModules().toArray()[0]).getModuleRules().toArray()[0]).getRuleMasterValues().toArray()[0]);
			assertEquals(ruleVal.getRuleValue(), "5");
			assertEquals(ruleVal.getRuleName(), "LOCK_AFTER_NO_OF_ATTEMPTS");
		} catch (Exception e) {
			logger.error("Error while Retriving module: ", e);
			Assert.fail("Error while Retriving module:");
		}
	}
}