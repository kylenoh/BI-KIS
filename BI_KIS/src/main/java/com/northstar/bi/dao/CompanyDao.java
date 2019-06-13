package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Company;

public interface CompanyDao {

	Company getCompanyByComNo(int comNo);
	List<Company> getCompanyList();
}
