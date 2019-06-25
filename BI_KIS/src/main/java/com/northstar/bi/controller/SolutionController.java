package com.northstar.bi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.service.SolutionService;

@Controller
public class SolutionController {
	
	@Autowired SolutionService solutionService;
	
	@RequestMapping(value = "/solution", method = RequestMethod.GET)
	public String Solution(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						   @RequestParam(name="categoryName", required=false) String categoryName,
						Model model,SolutionCriteria criteria) {
		
		
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		
		int totalRows = solutionService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Solution>solutions = solutionService.getSolutionList(criteria);
		model.addAttribute("solutions",solutions);
		model.addAttribute("pagination", pagination);
		
		return "solution/solution";
	}
	
	@RequestMapping(value = "/solutionWrite", method = RequestMethod.GET)
	public String SolutionWrite() {
		return "solution/solutionWrite";
	}
	
	@RequestMapping(value = "/solutionUpload", method = RequestMethod.POST)
	public String solutionUpload(Solution solution, SolutionFile solutionFile, HttpSession session, MultipartHttpServletRequest files) {
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		solution.setEMP_ID(User.getId());
		System.out.println(User.getId());
		solutionService.insertSolution(solution, solutionFile, session, files);
		return "redirect:/solution";
	}

}
