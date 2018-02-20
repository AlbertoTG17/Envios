package com.envios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envios.dao.UserDAO;
import com.envios.model.UserInfo;




@Service
public class UserService{
	
	@Autowired	
	private UserDAO userDAO;
	
	public UserInfo getDataByUserName(String userName) {
		return userDAO.getActiveUser(userName);
	}
} 
