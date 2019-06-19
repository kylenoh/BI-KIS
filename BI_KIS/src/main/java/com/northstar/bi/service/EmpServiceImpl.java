package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.EmpDao;
import com.northstar.bi.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao empDao;
	
	@Override
	public List<Emp> getEmpList() {
		return empDao.getEmpList();
	}
	@Override
	public Emp getEmpById(String empId) {
		return empDao.getEmpById(empId);
	}
}
