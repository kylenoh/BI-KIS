package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;

public interface CompanyDao {

	List<Customer> getCustomerListByCompanyNo(int companyNo);
	List<Company> getCompanyList();
	List<Company> getCompanyByCriteria(Criteria criteria);
	Company getCompanyByComNo(int comNo);
	Customer getCustomerByNo(int customerNo);
	Company getCompanyDetail(Customer customer);
	int getCompanyCount(Criteria criteria);
	void addCompany(Company company);
	void addCustomer(Customer customer);
	void deleteCustomer(int customerNo);
	void deleteCustomerByCompanyNo(int companyNo);
	void deleteCompany(int companyNo);
	void modifyCompany(Company company);
	void modifyCustomer(Customer customer);
}
