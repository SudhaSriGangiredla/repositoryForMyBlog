package com.org.coop.society.data.admin.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_credential database table.
 * 
 */
@Entity
@Table(name="user_credential")
@NamedQuery(name="UserCredential.findAll", query="SELECT u FROM UserCredential u")
public class UserCredential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="last_login")
	private Timestamp lastLogin;

	@Column(name="last_unsuccessful_login")
	private Timestamp lastUnsuccessfulLogin;

	private String password;

	@Column(name="transaction_pwd")
	private String transactionPwd;

	@Column(name="unsuccessful_login_count")
	private int unsuccessfulLoginCount;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserCredential() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getLastUnsuccessfulLogin() {
		return this.lastUnsuccessfulLogin;
	}

	public void setLastUnsuccessfulLogin(Timestamp lastUnsuccessfulLogin) {
		this.lastUnsuccessfulLogin = lastUnsuccessfulLogin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTransactionPwd() {
		return this.transactionPwd;
	}

	public void setTransactionPwd(String transactionPwd) {
		this.transactionPwd = transactionPwd;
	}

	public int getUnsuccessfulLoginCount() {
		return this.unsuccessfulLoginCount;
	}

	public void setUnsuccessfulLoginCount(int unsuccessfulLoginCount) {
		this.unsuccessfulLoginCount = unsuccessfulLoginCount;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}