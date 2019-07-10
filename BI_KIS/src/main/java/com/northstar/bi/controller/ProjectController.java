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
import org.springframework.web.bind.annotation.ResponseBody;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Project;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.CompanyService;
import com.northstar.bi.service.EmpService;
import com.northstar.bi.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	CompanyService companyService;
	@Autowired
	EmpService empService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/getEmpByEmpIdInfo")
	public @ResponseBody Emp EmpByEmpIdInfo(@RequestParam("empId")String empId) {
		Emp empInfo = empService.getEmpById(empId); 
		return empInfo;
	}
	@RequestMapping(value="/getCustomerByProjectInfo")
	public @ResponseBody List<Customer> CustomerByCompanyInfo (@RequestParam("projectNo")int projectNo){
		Company company = companyService.getCompanyByProjectNo(projectNo);
		List<Customer> customers = companyService.getCustomerListByCompanyNo(company.getNo()); 
		return customers;
	}
	
	@RequestMapping(value="/project")
	public String project(@RequestParam(name="cp", required=false,defaultValue="1")int cp,
						@RequestParam(name="title", required=false)String title,
						@RequestParam(name="companyName", required=false)String companyName,
						@RequestParam(name="dateOpt", required=false,defaultValue="all")String dateOpt,
						@RequestParam(name="fromDate", required=false,defaultValue="nodate")String fromDate,
						@RequestParam(name="toDate", required=false,defaultValue="nodate")String toDate,
						@RequestParam(name="flag", required=false,defaultValue = "start")String flag,
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
		criteria.setTitle(title);
		criteria.setCompanyName(companyName);
		criteria.setDateOpt(dateOpt);
		criteria.setFromDate(fromDate);
		criteria.setToDate(toDate);
		criteria.setFlag(flag);
		
		
		int totalRows = projectService.getProjectCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Project> pjtList = projectService.getProjectByCriteria(criteria);
		
		model.addAttribute("pjtList",pjtList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("totalRows",totalRows);
		
		return "project/project";
	}
	@RequestMapping(value="/addproject", method=RequestMethod.GET)
	public String addProjectForm(Model model) {
		List<Company> companyList = companyService.getCompanyList();
		List<Emp> empList = empService.getEmpList();
		
		model.addAttribute("companyList",companyList);
		model.addAttribute("empList",empList);
		return "project/pjtAddForm";
	}
	@RequestMapping(value="/pjtdetail")
	public String pjtDetail(Model model, int pjtNo) {
		Project pjt = projectService.getProjectByNo(pjtNo);
		
		model.addAttribute("pjt",pjt);
		return "project/projectDetail";
	}
	@RequestMapping(value="/pjtadd", method=RequestMethod.POST)
	public String pjtadd(@RequestParam("companyNo") int compnayNo,
					     @RequestParam(value="emp-info",required=false)List<String> empId,
							Project project, HttpSession session) throws ParseException {
		Emp loginEmp = (Emp) session.getAttribute("LOGIN_EMP");
		Company company = companyService.getCompanyByComNo(compnayNo);
		int pjtNo = projectService.getProjectNo();
		project.setNo(pjtNo);
		project.setCompany(company);
		project.setFlag("Y");
		project.setMsg("진행예정");
		project.setRegistrant(loginEmp);
		
		projectService.addProject(project);
		
		if(null != empId) {
			projectService.addEmpPro(empId, pjtNo);
		}
		return "redirect:/project";
	}
	@RequestMapping(value="/pjtdelete")
	public String pjtdelete(int pjtNo) {
		projectService.deleteEmpProByProjectNo(pjtNo);
		projectService.deleteProject(pjtNo);
		return "redirect:/project";
	}
	@RequestMapping(value="pjtmodify", method=RequestMethod.GET)	
	public String pjtmodifyForm(Model model,int pjtNo) {
		Project pjt = projectService.getProjectByNo(pjtNo);
		List<Company> companyList = companyService.getCompanyList();
		List<Emp> empList = empService.getEmpList();
		
		model.addAttribute("pjt",pjt);
		model.addAttribute("companyList",companyList);
		model.addAttribute("empList",empList);
		return "project/pjtModifyForm";
	}
	@RequestMapping(value="pjtmodify", method=RequestMethod.POST)
	public String pjtmodify(@RequestParam("companyNo") int compnayNo,
							@RequestParam(value="emp-info",required=false)List<String> empId,
							Project pjt) throws ParseException {
		Company company = companyService.getCompanyByComNo(compnayNo);
		
		pjt.setCompany(company);
		if ("Y".equals(pjt.getFlag())) {
			pjt.setMsg("진행예정");
		}
		if ("P".equals(pjt.getFlag())) {
			pjt.setMsg("진행중");
		}
		if ("N".equals(pjt.getFlag())) {
			pjt.setMsg("종료");
		}
		
		if(null != empId) {
			projectService.deleteEmpPro(empId,pjt.getNo());
			projectService.addEmpPro(empId,pjt.getNo());
		}
		projectService.modifyProject(pjt);
		return "redirect:/pjtdetail?pjtNo=" + pjt.getNo();
	}
}
