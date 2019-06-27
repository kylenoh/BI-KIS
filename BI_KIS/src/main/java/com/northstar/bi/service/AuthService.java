package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;

public interface AuthService {
//	Select
	int getTotalRows (AuthCriteria criteria);
	List<Auth> getAuthList (AuthCriteria criteria);
}
