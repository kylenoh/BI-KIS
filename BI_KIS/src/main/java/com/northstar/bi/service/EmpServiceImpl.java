package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.EmpDao;
import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao empDao;
	@Override
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
	}
	@Override
	public List<Auth> getAuthList() {
		return empDao.getAuthList();
	}
	@Override
	public List<Emp> getEmpByCriteria(Criteria criteria) {
		return empDao.getEmpByCriteria(criteria);
	}
	@Override
	public int getEmpCount(Criteria criteria) {
		return empDao.getEmpCount(criteria);
	}
	@Override
	public List<Emp> getEmpList() {
		return empDao.getEmpList();
	}
	@Override
	public Emp getEmpById(String empId) {
		return empDao.getEmpById(empId);
	}
}
