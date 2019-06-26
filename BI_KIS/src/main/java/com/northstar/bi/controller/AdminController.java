package com.northstar.bi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.EmpService;

@Controller
public class AdminController {

	@Autowired
	EmpService empService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/empAdmin")
	public String empAdmin (@RequestParam(name="cp", required=false, defaultValue="1")int cp,
							@RequestParam(name="name", required=false)String name,
							@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
							Model model, Criteria criteria, HttpSession session) {
		Category category = new Category();
		if(cateNo == 0) {
			category = (Category)session.getAttribute("HEADER_VALUE");
		}
		if(cateNo != 0) {
			category = categoryService.getCategoryByCategoryNo(cateNo);
		}
		session.setAttribute("HEADER_VALUE", category);
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
		model.addAttribute("totalRows",totalRows);
		return "admin/empAdmin";
	}
	@RequestMapping(value="empDetail")
	public String empDetail (String empId, Model model) {
		Emp emp = empService.getEmpById(empId);
		model.addAttribute("emp",emp);
		return "admin/empDetail";
	}
	@RequestMapping(value="empAuthUpdate")
	public @ResponseBody String empAuthUpdate(@RequestParam(name="authNo")int authNo,
							@RequestParam(name="empId")String empId) {
		Emp emp = empService.getEmpById(empId);
		Auth auth = new Auth();
		auth.setNo(authNo);
		emp.setAuth(auth);
		emp.setId(empId);
		empService.updateEmp(emp);
		return "";
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
							@RequestParam(name="addr")String addr,
							@RequestParam(name="email")String email,
							HttpSession session) {
		Emp emp = empService.getEmpById(empId);
		Category category = (Category)session.getAttribute("HEADER_VALUE");
		emp.setName(name);
		emp.setRank(rank);
		emp.setTel(tel);
		emp.setAddr(addr);
		emp.setEmail(email);
		empService.updateEmp(emp);
		return "redirect:/" + category.getCATE_VALUE();
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
	@RequestMapping(value="addEmp", method=RequestMethod.GET)
	public String addEmpForm () {
		return "admin/empAddForm";
	}
	@RequestMapping(value="addEmp", method=RequestMethod.POST)
	public String addEmp(@RequestParam(name="empId")String empId,
						@RequestParam(name="password")String password,
						@RequestParam(name="name")String name,
						@RequestParam(name="rank")String rank,
						@RequestParam(name="tel")String tel,
						@RequestParam(name="addr")String addr,
						@RequestParam(name="email")String email) {
		Emp emp = new Emp();
		emp.setId(empId);
		emp.setPassword(password);
		emp.setName(name);
		emp.setRank(rank);
		emp.setTel(tel);
		emp.setAddr(addr);
		emp.setEmail(email);
		
		empService.addEmp(emp);
		return "redirect:/empAdmin";
	}
}
