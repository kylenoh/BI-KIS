package com.northstar.bi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Project;
import com.northstar.bi.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/project")
	public String project(HttpSession session, Model model) {
		List<Project> pjtList = projectService.getProjectList();
		
		model.addAttribute("pjtList",pjtList);
		return "project/project";
	}
	@RequestMapping(value="/addproject", method=RequestMethod.GET)
	public String addProjectForm(HttpSession session, Model model) {
		return "project/addproject";
	}
	@RequestMapping(value="/pjtdetail")
	public String pjtDetail(HttpSession session, Model model, int pjtNo) {
		Project pjt = projectService.getProjectByNo(pjtNo);
		
		model.addAttribute("pjt",pjt);
		return "project/projectDetail";
	}
	@RequestMapping(value="/addproject", method=RequestMethod.POST)
	public String addProject(@RequestParam("title") String title,
							@RequestParam("company") String compnay,
							@RequestParam("startDate") Date startDate,
							@RequestParam(value="endDate",required=false) Date endDate,
							@RequestParam(value="content",required=false) String content,
							@RequestParam(value="remark",required=false) String remark,
							HttpSession session) {
		
		return "";
	}
		
	
}
