package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Company;

public interface CompanyService {

	List<Company> getCompanyList();
	Company getCompanyByComNo(int comNo);
}
