package com.northstar.bi.dao;

import com.northstar.bi.dto.Emp;

public interface EmpDao {

	Emp getEmpById(String empId);
	Emp getEmpByProNo(int proNo);
}
