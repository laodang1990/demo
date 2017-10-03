package com.jcloud.cms.service;

import com.jcloud.cms.domain.User;

/**
 * @author dyc
 * @version 1.0
 */
public interface UserService{

	User findByName(String name);

	void addUser(User user);
}
