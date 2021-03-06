package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.AuthDao;
import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired AuthDao authDao;
	
	@Override
	public List<Auth> getAuthList() {
		return authDao.getAuthList();
	}
	
	@Override
	public int getTotalRows() {
		return authDao.getTotalRows();
	}
	
}


