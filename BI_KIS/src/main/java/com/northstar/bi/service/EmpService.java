package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Emp;

public interface EmpService {

	List<Auth> getAuthList();
	int getEmpCount(Criteria criteria);
	List<Emp> getEmpByCriteria(Criteria criteria);
	List<Emp> getEmpList();
	Emp getEmpById(String emp);
}
