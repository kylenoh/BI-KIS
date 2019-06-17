package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.CompanyDao;
import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;
@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	@Override
	public List<Company> getCompanyList() {
		return companyDao.getCompanyList();
	}
	@Override
	public List<Company> getCompanyByCriteria(Criteria criteria) {
		return companyDao.getCompanyByCriteria(criteria);
	}
	@Override
	public Company getCompanyDetail(int companyNo, int customerNo) {
		Customer customer = new Customer();
		Company company = new Company();
		company.setNo(companyNo);
		customer.setCompany(company);
		customer.setNo(customerNo);
		return companyDao.getCompanyDetail(customer);
	}
	@Override
	public Customer getCustomerByNo(int customerNo) {
		return companyDao.getCustomerByNo(customerNo);
	}
	@Override
	public Company getCompanyByComNo(int comNo) {
		return companyDao.getCompanyByComNo(comNo);
	}
	@Override
	public int getCompanyCount(Criteria criteria) {
		return companyDao.getCompanyCount(criteria);
	}
	@Override
	public void addCompany(Company company) {
		companyDao.addCompany(company);
	}
	@Override
	public void addCustomer(Customer customer) {
		companyDao.addCustomer(customer);
	}
	@Override
	public void deleteCustomer(int customerNo) {
		companyDao.deleteCustomer(customerNo);
	}
	@Override
	public void deleteCustomerByCompanyNo(int companyNo) {
		companyDao.deleteCustomerByCompanyNo(companyNo);
	}
	@Override
	public void deleteCompany(int companyNo) {
		companyDao.deleteCompany(companyNo);
	}
	@Override
	public void modifyCompany(Company company) {
		companyDao.modifyCompany(company);
	}
	@Override
	public void modifyCustomer(Customer customer) {
		companyDao.modifyCustomer(customer);
	}
}
