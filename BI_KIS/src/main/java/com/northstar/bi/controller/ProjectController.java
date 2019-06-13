package com.northstar.bi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Company;
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
	public String project(HttpSession session, Model model) {
		List<Project> pjtList = projectService.getProjectList();
		
		model.addAttribute("pjtList",pjtList);
		return "project/project";
	}
	@RequestMapping(value="/addproject", method=RequestMethod.GET)
	public String addProjectForm(HttpSession session, Model model) {
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("companyList",companyList);
		return "project/pjtAddForm";
	}
	@RequestMapping(value="/pjtdetail")
	public String pjtDetail(HttpSession session, Model model, int pjtNo) {
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
							@RequestParam(value="remark",required=false) String remark,
							HttpSession session) throws ParseException {
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
	public String pjtdelete(HttpSession session, Model model,int pjtNo) {
		projectService.deleteProject(pjtNo);
		return "redirect:/project";
	}
	@RequestMapping(value="pjtmodify", method=RequestMethod.GET)	
	public String pjtupdateForm(HttpSession session, Model model,int pjtNo) {
		Project pjt = projectService.getProjectByNo(pjtNo);
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("pjt",pjt);
		model.addAttribute("companyList",companyList);
		return "project/pjtModifyForm";
	}
	@RequestMapping(value="pjtmodify", method=RequestMethod.POST)
	public String pjtupdate(@RequestParam("pjtNo") int pjtNo,
							@RequestParam("title") String title,
							@RequestParam("companyNo") int compnayNo,
							@RequestParam("startDate") String startDate,
							@RequestParam(value="endDate",required=false) String endDate,
							@RequestParam(value="content") String content,
							@RequestParam(value="remark",required=false) String remark,
							@RequestParam("flag") String flag,
							HttpSession session, Model model) throws ParseException {
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
		} else if ("P".equals(flag)) {
			pjt.setMsg("진행중");
		} else {
			pjt.setMsg("종료");
		}
		projectService.updateProject(pjt);
		return "redirect:/pjtdetail?pjtNo=" + pjtNo;
	}
}
