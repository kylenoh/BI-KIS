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
import com.northstar.bi.dto.Project;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.CompanyService;
import com.northstar.bi.service.ProjectService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/company")
	public String company(@RequestParam(name="cp", required=false,defaultValue="1")int cp,
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
		
		int totalRows = companyService.getCompanyCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Company> companyList = companyService.getCompanyByCriteria(criteria);
		
		model.addAttribute("companyList",companyList);
		model.addAttribute("pagination",pagination);
		
		return "company/company";
	}
	@RequestMapping(value="/companyDetail")
	public String companyDetail(@RequestParam(name="companyNo")int companyNo,
								Model model) {
		Company company = companyService.getCompanyByComNo(companyNo);
		
		model.addAttribute("company",company);
		return "company/companyDetail";
	}
	@RequestMapping(value="/customerDetail")
	public String customerDetail(@RequestParam(name="customerNo")int customerNo,
								Model model) {
		Customer customer = companyService.getCustomerByNo(customerNo);
		
		model.addAttribute("customer",customer);
		return "company/customerDetail";
	}
	@RequestMapping(value="addCompany", method=RequestMethod.GET)
	public String addCompanyForm(Model model) {
		return "company/companyAddForm";
	}
	@RequestMapping(value="addCompany", method=RequestMethod.POST)
	public String addCompany(Company company, HttpSession session, Model model) {
		int companyNo = companyService.getCompanyNo();
		Emp emp = (Emp)session.getAttribute("LOGIN_EMP");
		
		company.setNo(companyNo);
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
	public String addCustomer(@RequestParam(name="companyNo")int companyNo,
							Customer customer, HttpSession session, Model model) {
		Company company = companyService.getCompanyByComNo(companyNo);
		int customerNo = companyService.getCustomerNo();
		Emp emp = (Emp)session.getAttribute("LOGIN_EMP");
		
		customer.setNo(customerNo);
		customer.setCompany(company);
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
		List<Project> projectList = projectService.getProjectByCompanyNo(companyNo);
		for(Project project : projectList) {
			projectService.deleteEmpProByProjectNo(project.getNo());
			projectService.deleteProject(project.getNo());
		}
		return "redirect:/company";
	}
	@RequestMapping(value="companyModify", method=RequestMethod.GET)
	public String companyModifyForm(Model model, int companyNo) {
		Company company = companyService.getCompanyByComNo(companyNo);
		model.addAttribute("company",company);
		return "company/companyModifyForm";
	}
	@RequestMapping(value="companyModify", method=RequestMethod.POST)
	public String companyModify(Company company,Model model) {
		companyService.modifyCompany(company);
		return "redirect:/companyDetail?companyNo=" + company.getNo();
	}
	@RequestMapping(value="customerModify", method=RequestMethod.GET)
	public String customerModifyForm(Model model, int customerNo) {
		Customer customer = companyService.getCustomerByNo(customerNo);
		model.addAttribute("customer",customer);
		return "company/customerModifyForm";
	}
	@RequestMapping(value="customerModify", method=RequestMethod.POST)
	public String customerModify(Customer customer, Model model) {
		
		companyService.modifyCustomer(customer);
		
		return "redirect:/customerDetail?customerNo=" + customer.getNo();
	}
}
