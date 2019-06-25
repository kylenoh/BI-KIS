package com.northstar.bi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.northstar.bi.dao.ProjectDao;
import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Project;
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
						@RequestParam(name="flag", required=false)String flag,
						@RequestParam(name="categoryName", required = false, defaultValue = "프로젝트")String categoryName,
							Model model, Criteria criteria, HttpSession session) throws ParseException {
		session.setAttribute("HEADER_VALUE", categoryName);
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
	public String pjtadd(@RequestParam("title") String title,
							@RequestParam("companyNo") int compnayNo,
							@RequestParam("startDate") String startDate,
							@RequestParam(value="endDate",required=false,defaultValue="nodate") String endDate,
							@RequestParam(value="content") String content,
							@RequestParam(value="remark",required=false) String remark,
							@RequestParam(value="emp-info",required=false)List<String> empId,
							HttpSession session) throws ParseException {
		Project project = new Project();
		Emp loginEmp = (Emp) session.getAttribute("LOGIN_EMP");
		Company company = companyService.getCompanyByComNo(compnayNo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int pjtNo = projectService.getProjectNo();
		project.setNo(pjtNo);
		project.setTitle(title);
		project.setCompany(company);
		project.setStartDate(formatter.parse(startDate));
		if(!("nodate".equals(endDate))) {
			project.setEndDate(formatter.parse(endDate));
		}
		project.setContent(content);
		project.setRemark(remark);
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
	public String pjtmodify(@RequestParam("pjtNo") int pjtNo,
							@RequestParam("title") String title,
							@RequestParam("companyNo") int compnayNo,
							@RequestParam("startDate") String startDate,
							@RequestParam(value="endDate",required=false,defaultValue="nodate") String endDate,
							@RequestParam(value="content") String content,
							@RequestParam(value="remark",required=false) String remark,
							@RequestParam("flag") String flag,
							@RequestParam(value="emp-info",required=false)List<String> empId) throws ParseException {
		Project pjt = projectService.getProjectByNo(pjtNo); 
		Company company = companyService.getCompanyByComNo(compnayNo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		pjt.setTitle(title);
		pjt.setCompany(company);
		pjt.setStartDate(formatter.parse(startDate));
		if(!("nodate".equals(endDate))) {
			pjt.setEndDate(formatter.parse(endDate));
		}
		pjt.setContent(content);
		pjt.setRemark(remark);
		pjt.setFlag(flag);
		if ("Y".equals(flag)) {
			pjt.setMsg("진행예정");
		}
		if ("P".equals(flag)) {
			pjt.setMsg("진행중");
		}
		if ("N".equals(flag)) {
			pjt.setMsg("종료");
		}
		
		if(null != empId) {
			projectService.deleteEmpPro(empId,pjtNo);
			projectService.addEmpPro(empId,pjtNo);
		}
		projectService.modifyProject(pjt);
		return "redirect:/pjtdetail?pjtNo=" + pjtNo;
	}
}
