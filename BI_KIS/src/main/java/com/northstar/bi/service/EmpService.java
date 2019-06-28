package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Emps;

public interface EmpService {

	void addEmp(Emp emp);
	void updateEmp(Emp emp);
	List<Auth> getAuthList();
	int getEmpCount(Criteria criteria);
	List<Emp> getEmpByCriteria(Criteria criteria);
	List<Emp> getEmpList();
	Emp getEmpById(String emp);
	Emps idCheck(String empId);
}
