package com.northstar.bi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.northstar.bi.dto.Emp;
import com.northstar.bi.service.EmpService;

@Controller
public class MainController {

	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/")
	public String main(HttpSession session, Model model) {
		return "main";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		Emp emp = new Emp();
		emp.setId(id);
		emp = empService.getEmpById(emp);
		
		if (emp == null ) {
			return "fail";
		}
		if (!emp.getPassword().equals(password)) {
			return "fail";
		}
		session.setAttribute("LOGIN_EMP", emp);
		return "redirect:/";
	}

	
}
