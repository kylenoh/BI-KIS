package com.northstar.bi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.EmpService;
import com.northstar.bi.service.PropertyService;
import com.northstar.bi.utils.DateManager;

@Controller
public class PropertyController {

	@Autowired PropertyService propService;
	@Autowired CategoryService categoryService;
	@Autowired EmpService empService;
	
//	페이징
	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String Property(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
						@RequestParam(name="PROP_NAME", required = false)String  PROP_NAME,
						@RequestParam(name="PROP_NO", required = false)String  PROP_NO,
						@RequestParam(name="EMP_ID", required = false)String  EMP_ID,
						@RequestParam(name="PROP_FLAG", required = false)String  PROP_FLAG,
						Model model,PropertyCriteria criteria,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Category category = new Category();
		if(cateNo == 0) {
			category = (Category)session.getAttribute("HEADER_VALUE");
		}
		if(cateNo != 0) {
			category = categoryService.getCategoryByCategoryNo(cateNo);
		}
		session.setAttribute("HEADER_VALUE", category);
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setPROP_NAME(PROP_NAME);
		criteria.setPROP_NO(PROP_NO);
		criteria.setEMP_ID(EMP_ID);
		criteria.setPROP_FLAG(PROP_FLAG);
		
		int totalRows = propService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		DateManager.getToday(request, response);
		List<Property>props = propService.getPropertyList(criteria);
		model.addAttribute("props", props);
		model.addAttribute("pagination", pagination);
		
		return "property/property";
	}
//	자산 등록 게시판 진입
	@RequestMapping(value = "/propertyWrite", method = RequestMethod.GET)
	public String PropertyWrite(Model model,HttpServletRequest request,HttpServletResponse response) {
		List<Emp> empList = empService.getEmpList();
		model.addAttribute("empList",empList);
		DateManager.getToday(request, response);
		return "property/propertyWrite";
	}
//	자산 수정 게시판 진입
	@RequestMapping(value = "/propertyModify", method = RequestMethod.GET)
	public String PropertyWrite(@RequestParam("no")int no, Model model,HttpServletRequest request,HttpServletResponse response) {
		Property prop = propService.getPropertyByNo(no);
		if (prop.getPROP_DATE()==null) {
			Date today = new Date();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			prop.setPROP_DATE(sdf.format(today));
		}
		List<Emp> empList = empService.getEmpList();
		model.addAttribute("empList",empList);
		model.addAttribute("prop", prop);
		return "property/propertyModify";
	}
//	게시글 사용 여부 변경
	@RequestMapping(value = "/propertyDelete", method = RequestMethod.GET)
	public String PropertyDelete(@RequestParam("no")int no,
						 Property prop) {
		prop.setNO(no);
		propService.Delete(prop);
		return "redirect:/property";
	}
//	품목 등록
	@RequestMapping(value = "/regProperty", method = RequestMethod.POST)
	public String PropertyRegister(Property prop) {
		propService.register(prop);
		System.out.println(prop.getBUY_DATE());
		return "redirect:/property";
	}
//	품목 수정
	@RequestMapping(value = "/Modify", method = RequestMethod.POST)
	public String PropertyModify(Property prop) {
		propService.Modify(prop);
		return "redirect:/property";
	}

}
