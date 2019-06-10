package com.northstar.bi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.EmpDao;
import com.northstar.bi.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao empDao;
	
	@Override
	public Emp getEmpById(String empId) {
		Emp test1 = empDao.getEmpById(empId);
		System.out.println(test1.getId());
		return empDao.getEmpById(empId);
	}
}
