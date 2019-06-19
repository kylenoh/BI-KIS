package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Emp;

public interface EmpDao {

	List<Emp> getEmpList();
	Emp getEmpById(String empId);
	Emp getEmpByProNo(int proNo);
}
