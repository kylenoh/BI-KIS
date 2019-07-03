package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;

public interface AuthDao {
	int getTotalRows ();
	List<Auth> getAuthList ();
}
