package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;

public interface AuthService {
//	Insert
	void Authregister(Auth auth);
//	Select
	int getTotalRows (AuthCriteria criteria);
	List<Auth> getAuthList (AuthCriteria criteria);
	Auth getAuthByNo(int no);
//	Update
	void AuthModify(Auth auth);
	void AuthDelete(Auth auth);
}
