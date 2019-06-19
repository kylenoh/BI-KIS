package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Emp;

public interface EmpService {

	List<Emp> getEmpList();
	Emp getEmpById(String emp);
}
