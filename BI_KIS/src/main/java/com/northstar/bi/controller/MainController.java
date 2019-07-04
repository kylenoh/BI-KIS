package com.northstar.bi.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.EmpService;

@Controller
public class MainController {

	@Autowired
	EmpService empService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/")
	public String main(HttpSession session, Model model) {
		return "main";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginFail() {
		return "login-fail";
	}
	@RequestMapping(value="/getCateSectionListByDivisionName")
	public @ResponseBody List<Category> getSectionList(String divisionName) {
		List<Category> SectionList = categoryService.getCateSectionListByDivisionName(divisionName);
		return SectionList;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		Emp emp = new Emp();
		emp = empService.getEmpById(id);
		List<Category> categoryList = categoryService.getCategoryList();
		
		if (emp == null ) {
			return "redirect:/login?login=fail";
		}
		if (!emp.getPassword().equals(password)) {
			return "redirect:/login?login=fail";
		}
		if(emp.getFlag().equals("N")) {
			return "redirect:/login?login=flag";
		}
		session.setAttribute("LOGIN_EMP", emp);
		session.setAttribute("CATEGORY_LIST", categoryList);
		return "redirect:/project?cateNo=1";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN_EMP");
		session.removeAttribute("CATEGORY_LIST");
		session.removeAttribute("HEADER_VALUE");
		return "main";
	}
	@RequestMapping(value="imageUpload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String upload(@RequestParam("uploadFile") MultipartFile mf,HttpServletRequest request, HttpSession session)throws Exception {
			String saveDirectory = request.getSession().getServletContext().getRealPath("BI_KIS");
			String fileName = mf.getOriginalFilename();
			String filepath = saveDirectory + "\\" + fileName;
			File f = new File(filepath);
			if( !f.exists()) {
				f.mkdirs();
			}
			mf.transferTo(f);
			return saveDirectory + fileName;
	}
	
}
