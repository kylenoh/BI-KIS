package com.northstar.bi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Company;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Project;
import com.northstar.bi.service.CompanyService;
import com.northstar.bi.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	CompanyService companyService;
	
	
	@RequestMapping(value="/project")
	public String project(@RequestParam(name="cp", required=false,defaultValue="1")int cp,
						@RequestParam(name="title", required=false)String title,
						@RequestParam(name="companyName", required=false)String companyName,
						@RequestParam(name="startDate", required=false,defaultValue="nodate")String startDate,
						@RequestParam(name="endDate", required=false,defaultValue="nodate")String endDate,
						@RequestParam(name="flag", required=false)String flag,
							Model model, Criteria criteria) throws ParseException {
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setTitle(title);
		criteria.setCompanyName(companyName);
		criteria.setStartDate(startDate);
		criteria.setEndDate(endDate);
		criteria.setFlag(flag);
		
		int totalRows = projectService.getProjectCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Project> pjtList = projectService.getProjectByCriteria(criteria);
		
		model.addAttribute("pjtList",pjtList);
		model.addAttribute("pagination",pagination);
		
		return "project/project";
	}
	@RequestMapping(value="/addproject", method=RequestMethod.GET)
	public String addProjectForm(Model model) {
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("companyList",companyList);
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
							@RequestParam(value="endDate",required=false) String endDate,
							@RequestParam(value="content") String content,
							@RequestParam(value="remark",required=false) String remark) throws ParseException {
		Project project = new Project();
		Company company = companyService.getCompanyByComNo(compnayNo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		project.setTitle(title);
		project.setCompany(company);
		project.setStartDate(formatter.parse(startDate));
		project.setEndDate(formatter.parse(endDate));
		project.setContent(content);
		project.setRemark(remark);
		project.setFlag("Y");
		project.setMsg("진행예정");
		
		projectService.addProject(project);
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
		model.addAttribute("pjt",pjt);
		model.addAttribute("companyList",companyList);
		return "project/pjtModifyForm";
	}
	@RequestMapping(value="pjtmodify", method=RequestMethod.POST)
	public String pjtmodify(@RequestParam("pjtNo") int pjtNo,
							@RequestParam("title") String title,
							@RequestParam("companyNo") int compnayNo,
							@RequestParam("startDate") String startDate,
							@RequestParam(value="endDate",required=false) String endDate,
							@RequestParam(value="content") String content,
							@RequestParam(value="remark",required=false) String remark,
							@RequestParam("flag") String flag) throws ParseException {
		Project pjt = projectService.getProjectByNo(pjtNo); 
		Company company = companyService.getCompanyByComNo(compnayNo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		pjt.setTitle(title);
		pjt.setCompany(company);
		pjt.setStartDate(formatter.parse(startDate));
		pjt.setEndDate(formatter.parse(endDate));
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
		projectService.modifyProject(pjt);
		return "redirect:/pjtdetail?pjtNo=" + pjtNo;
	}
}
