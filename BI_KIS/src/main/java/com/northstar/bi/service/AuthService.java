package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;
import com.northstar.bi.dto.Property;

public interface AuthService {
//	Insert
	void Authregister(Auth auth);
//	Select
	int getTotalRows (AuthCriteria criteria);
	List<Property> getAuthList (AuthCriteria criteria);
	Property getAuthByNo(int no);
//	Update
	void AuthModify(Auth auth);
	void AuthDelete(Auth auth);
}
