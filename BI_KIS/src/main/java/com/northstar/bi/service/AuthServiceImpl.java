package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.AuthDao;
import com.northstar.bi.dao.PropertyDao;
import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;
import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired AuthDao authDao;
	@Override
	public void Authregister(Auth auth) {
		authDao.Authregister(auth);
	}
	
	@Override
	public List<Auth> getAuthList(AuthCriteria criteria) {
		return authDao.getAuthList(criteria);
	}
	
	@Override
	public int getTotalRows(AuthCriteria criteria) {
		return authDao.getTotalRows(criteria);
	}
	
	@Override
	public Property getAuthByNo(int no) {
		return authDao.getAuthByNo(no);
	}
	@Override
	public void AuthModify(Auth auth) {
		authDao.AuthModify(auth);
	}
	@Override
	public void AuthDelete(Auth auth) {
		authDao.AuthDelete(auth);
	}
	
}


