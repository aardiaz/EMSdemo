package com.bway.springproject.service;

import com.bway.springproject.model.User;

public interface IUserService {
	
	void userSignup(User user);
	User userLogin(String userName, String password);
}
