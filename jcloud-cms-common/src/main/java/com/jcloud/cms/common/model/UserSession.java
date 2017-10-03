package com.jcloud.cms.common.model;

/**
 * @author dyc
 * @date 2015年11月13日上午11:01:03 
 * @version 1.0
 */
public class UserSession implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String phone;
	
	private Long userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
