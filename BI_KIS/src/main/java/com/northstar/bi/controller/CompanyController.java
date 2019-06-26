package com.northstar.bi.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/company")
	public String company(@RequestParam(name="cp", required=false,defaultValue="1")int cp,
						@RequestParam(name="name", required=false)String name,
						@RequestParam(name="customerName", required=false)String customerName,
						@RequestParam(name="email", required=false)String email,
						@RequestParam(name="dept", required=false)String dept,
						@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
							Model model, Criteria criteria, HttpSession session) throws ParseException {
		Category category = new Category();
		if(cateNo == 0) {
			category = (Category)session.getAttribute("HEADER_VALUE");
		}
		if(cateNo != 0) {
			category = categoryService.getCategoryByCategoryNo(cateNo);
		}
		session.setAttribute("HEADER_VALUE", category);
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setName(name);
		criteria.setCustomerName(customerName);
		criteria.setEmail(email);
		criteria.setDept(dept);
		
		int totalRows = companyService.getCompanyCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Company> companyList = companyService.getCompanyByCriteria(criteria);
		
		model.addAttribute("companyList",companyList);
		model.addAttribute("pagination",pagination);
		
		return "company/company";
	}
	@RequestMapping(value="/companyDetail")
	public String companyDetail(@RequestParam(name="companyNo")int companyNo,
								@RequestParam(name="customerNo",required=false,defaultValue="0")int customerNo,
								Model model) {
		Company company = companyService.getCompanyDetail(companyNo, customerNo);
		
		model.addAttribute("company",company);
		return "company/companyDetail";
	}
	@RequestMapping(value="addCompany", method=RequestMethod.GET)
	public String addCompanyForm(Model model) {
		return "company/companyAddForm";
	}
	@RequestMapping(value="addCompany", method=RequestMethod.POST)
	public String addCompany(@RequestParam(name="name")String name,
							@RequestParam(name="owner")String owner,
							@RequestParam(name="tel")String tel,
							@RequestParam(name="addr")String addr,
							@RequestParam(name="remark",required=false)String remark,
							HttpSession session, Model model) {
		Company company = new Company();
		int companyNo = companyService.getCompanyNo();
		Emp emp = (Emp)session.getAttribute("LOGIN_EMP");
		
		company.setNo(companyNo);
		company.setName(name);
		company.setOwner(owner);
		company.setTel(tel);
		company.setAddr(addr);
		company.setRemark(remark);
		company.setRegistrant(emp);
		
		companyService.addCompany(company);
		return "redirect:/company";
	}
	@RequestMapping(value="addCustomer", method=RequestMethod.GET)
	public String addCustomerForm(Model model) {
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("companyList",companyList);
		return "company/customerAddForm";
	}
	@RequestMapping(value="addCustomer", method=RequestMethod.POST)
	public String addCustomer(@RequestParam(name="name")String name,
							@RequestParam(name="rank")String rank,
							@RequestParam(name="dept")String dept,
							@RequestParam(name="tel1")String tel1,
							@RequestParam(name="tel2")String tel2,
							@RequestParam(name="email")String email,
							@RequestParam(name="companyNo")int companyNo,
							@RequestParam(name="remark",required=false)String remark,
							HttpSession session, Model model) {
		Customer customer = new Customer();
		Company company = companyService.getCompanyByComNo(companyNo);
		int customerNo = companyService.getCustomerNo();
		Emp emp = (Emp)session.getAttribute("LOGIN_EMP");
		
		customer.setNo(customerNo);
		customer.setName(name);
		customer.setRank(rank);
		customer.setDept(dept);
		customer.setTel1(tel1);
		customer.setTel2(tel2);
		customer.setEmail(email);
		customer.setCompany(company);
		customer.setRemark(remark);
		customer.setRegistrant(emp);
		
		companyService.addCustomer(customer);
		return "redirect:/company";
	}
	@RequestMapping(value="/customerDelete")
	public String customerDelete(Model model, int customerNo) {
		companyService.deleteCustomer(customerNo);
		return "redirect:/company";
	}
	@RequestMapping(value="/companyDelete")
	public String companyDelete(Model model, int companyNo) {
		companyService.deleteCustomerByCompanyNo(companyNo);
		companyService.deleteCompany(companyNo);
		return "redirect:/company";
	}
	@RequestMapping(value="companyModify", method=RequestMethod.GET)
	public String companyModifyForm(Model model, int customerNo) {
		Customer customer = companyService.getCustomerByNo(customerNo);
		model.addAttribute("customer",customer);
		return "company/companyModifyForm";
	}
	@RequestMapping(value="companyModify", method=RequestMethod.POST)
	public String companyModify(@RequestParam(name="companyNo")int companyNo,
								@RequestParam(name="name")String name,
								@RequestParam(name="owner")String owner,
								@RequestParam(name="tel")String tel,
								@RequestParam(name="addr")String addr,
								@RequestParam(name="remark",required=false)String remark,
								@RequestParam(name="cusNo")int cusNo,
								@RequestParam(name="cusName")String cusName,
								@RequestParam(name="cusRank")String cusRank,
								@RequestParam(name="cusDept")String cusDept,
								@RequestParam(name="cusTel1")String cusTel1,
								@RequestParam(name="cusTel2")String cusTel2,
								@RequestParam(name="cusEmail")String cusEmail,
								@RequestParam(name="cusRemark",required=false)String cusRemark,
								Model model) {
		Company company = companyService.getCompanyByComNo(companyNo);
		Customer customer = companyService.getCustomerByNo(cusNo);
		
		company.setNo(companyNo);
		company.setName(name);
		company.setOwner(owner);
		company.setTel(tel);
		company.setAddr(addr);
		company.setRemark(remark);
		companyService.modifyCompany(company);
		
		customer.setNo(cusNo);
		customer.setName(cusName);
		customer.setRank(cusRank);
		customer.setDept(cusDept);
		customer.setTel1(cusTel1);
		customer.setTel2(cusTel2);
		customer.setEmail(cusEmail);
		customer.setRemark(cusRemark);
		companyService.modifyCustomer(customer);
		
		return "redirect:/customerDetail?=customerNo=" + cusNo;
	}
}
