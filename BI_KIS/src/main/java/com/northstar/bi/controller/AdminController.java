package com.northstar.bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.service.EmpService;

@Controller
public class AdminController {

	@Autowired
	EmpService empService;

	@RequestMapping(value="/empAdmin")
	public String empAdmin (@RequestParam(name="cp", required=false, defaultValue="1")int cp,
							@RequestParam(name="name", required=false)String name,
							Model model, Criteria criteria) {
		int rows = 10;
		criteria.setBeginIndex((cp - 1 ) * rows + 1); 
		criteria.setEndIndex(cp * rows);
		criteria.setName(name);
		
		int totalRows = empService.getEmpCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Emp> empList = empService.getEmpByCriteria(criteria);
		List<Auth> authList = empService.getAuthList();
		
		model.addAttribute("empList", empList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("authList", authList);
		return "admin/empAdmin";
	}
	@RequestMapping(value="empModify", method=RequestMethod.GET)
	public String empModifyForm(String empId, Model model) {
		Emp emp = empService.getEmpById(empId);
		
		model.addAttribute("emp",emp);
		return "admin/empModifyForm";
	}
	@RequestMapping(value="empModify", method=RequestMethod.POST)
	public String empModify (@RequestParam(name="empId")String empId,
							@RequestParam(name="name")String name,
							@RequestParam(name="rank")String rank,
							@RequestParam(name="tel")String tel,
							@RequestParam(name="email")String email) {
		Emp emp = empService.getEmpById(empId);
		emp.setName(name);
		emp.setRank(rank);
		emp.setTel(tel);
		emp.setEmail(email);
		empService.updateEmp(emp);
		return "redirect:/empAdmin";
	}
	@RequestMapping(value="empDelete")
	public String empDelete (@RequestParam(name="empId")String empId,
							@RequestParam(name="flagCheck")String flagCheck) {
		Emp emp = empService.getEmpById(empId);
		if("사용".equals(flagCheck)) {
			emp.setFlag("Y");
		}
		if("미사용".equals(flagCheck)) {
			emp.setFlag("N");
		}
		empService.updateEmp(emp);
		return "redirect:/empAdmin";
	}
}
