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
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginFail() {
		return "login-fail";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		Emp emp = new Emp();
		emp = empService.getEmpById(id);
		
		if (emp == null ) {
			return "redirect:/login?login=fail";
		}
		if (!emp.getPassword().equals(password)) {
			return "redirect:/login?login=fail";
		}
		session.setAttribute("LOGIN_EMP", emp);
		return "redirect:/project";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN_EMP");
		return "main";
	}
	
}
