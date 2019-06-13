package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.CompanyDao;
import com.northstar.bi.dto.Company;
@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	@Override
	public List<Company> getCompanyList() {
		return companyDao.getCompanyList();
	}
	@Override
	public Company getCompanyByComNo(int comNo) {
		return companyDao.getCompanyByComNo(comNo);
	}
}
