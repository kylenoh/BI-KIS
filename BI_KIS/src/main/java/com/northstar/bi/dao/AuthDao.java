package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;

public interface AuthDao {
//	Insert
	void Authregister(Auth auth);
	
//	Select
	int getTotalRows (AuthCriteria criteria);
	List<Auth> getAuthList (AuthCriteria criteria);
	Auth getAuthByNo(int no);
//	Update
	void  AuthModify(Auth auth);
	void AuthDelete(Auth auth);
}
