package com.org.coop.admin.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.org.coop.bs.util.BusinessConstants;
import com.org.coop.society.data.admin.entities.RolePermission;
import com.org.coop.society.data.admin.entities.User;
import com.org.coop.society.data.admin.entities.UserRole;
import com.org.coop.society.data.admin.repositories.UserAdminRepository;
import com.org.coop.society.data.customer.repositories.UserRepository;
import com.sun.javafx.webkit.WebConsoleListener;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	private static final Logger log = Logger.getLogger(AdminLoginServiceImpl.class); 

	@Autowired
	private UserAdminRepository userAdminRepository;
	
	/**
	 * This method returns list of roles for a given user name
	 */
	@Transactional(value="adminTransactionManager")
	public List<String> getRole(String username) {
		List<String> roleList = new ArrayList<String>();
		User user = userAdminRepository.findByUserName(username);
		if(user != null) {
			for(UserRole userRole : user.getUserRoles()) {
				roleList.add(userRole.getRoleMaster().getRoleName().toUpperCase());
			}
		}
		return roleList;
	}
	
	/**
	 * This method returns list of permissions for a given user name
	 */
	@Transactional(value="adminTransactionManager")
	public List<String> getRolePermissions(String username) {
		List<String> permissionList = new ArrayList<String>();
		User user = userAdminRepository.findByUserName(username);
		if(user != null) {
			for(UserRole userRole : user.getUserRoles()) {
				for(RolePermission rolePerm : userRole.getRoleMaster().getRolePermissions()) {
					String permission = rolePerm.getPermissionMaster().getModuleMaster().getModuleName() + "_" + rolePerm.getPermissionMaster().getPermission();
					permissionList.add(permission);
				}
			}
		}
		return permissionList;
	}
	
	/**
	 * Once login is successful this method resets the counter
	 * @param username
	 */
	@Transactional(value="adminTransactionManager")
	public void successfulLogin(String username) {
		if(username != null) {
			User user = userAdminRepository.findByUserName(username);
			user.getUserCredential().setUnsuccessfulLoginCount(0);
			user.getUserCredential().setUpdateUser(username);
		}
	}
	
	/**
	 * Once login is successful this method resets the counter
	 * @param username
	 */
	@Transactional(value="adminTransactionManager")
	public void unsuccessfulLogin(String username) {
		if(username != null) {
			User user = userAdminRepository.findByUserName(username);
			int unsuccessfulLoginCounter = user.getUserCredential().getUnsuccessfulLoginCount();
			user.getUserCredential().setUnsuccessfulLoginCount(++unsuccessfulLoginCounter);
			user.getUserCredential().setLastUnsuccessfulLogin(new Timestamp(System.currentTimeMillis()));
			user.getUserCredential().setUpdateUser(username);
		}
	}
	
	
	/**
	 * Once login is successful this method will bring OTP or Security question
	 * @param username
	 */
	@Transactional(value="adminTransactionManager")
	public void getOTPOrSecurityQuestion(String username) {
		User user = userAdminRepository.findByUserName(username);
		Random rnd = new Random();
		int otp = 100000 + rnd.nextInt(900000);
		user.getUserCredentialOtp().setOtp(String.valueOf(otp));
		user.getUserCredentialOtp().setStartDate(new Timestamp(System.currentTimeMillis()));
		user.getUserCredentialOtp().setEndDate(new Timestamp(System.currentTimeMillis() + (BusinessConstants.OTP_VALIDITY * 60 * 1000)));
	}
}
