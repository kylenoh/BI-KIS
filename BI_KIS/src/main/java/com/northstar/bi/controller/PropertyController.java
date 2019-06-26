package com.northstar.bi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.PropertyService;

@Controller
public class PropertyController {

	@Autowired PropertyService propService;
	@Autowired CategoryService categoryService;
	
//	페이징
	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String Property(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
						Model model,PropertyCriteria criteria,HttpSession session) {
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
		
		int totalRows = propService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Property>props = propService.getPropertyList(criteria);
		model.addAttribute("props", props);
		model.addAttribute("pagination", pagination);
		
		return "property/property";
	}
//	자산 등록 게시판 진입
	@RequestMapping(value = "/propertyWrite", method = RequestMethod.GET)
	public String PropertyWrite() {
		return "property/propertyWrite";
	}
//	자산 수정 게시판 진입
	@RequestMapping(value = "/propertyModify", method = RequestMethod.GET)
	public String PropertyWrite(@RequestParam("no")int no, Model model) {
		Property prop = propService.getPropertyByNo(no);
		model.addAttribute("prop", prop);
		return "property/propertyModify";
	}
//	게시글 사용 여부 변경
	@RequestMapping(value = "/propertyDelete", method = RequestMethod.GET)
	public String PropertyDelete(@RequestParam("no")int no,
						 @RequestParam("flag")String flag,
						 Property prop) {
		System.out.println(flag);
		if (flag.equals("N")) {
			prop.setFLAG("Y");
		}else {
			prop.setFLAG("N");
		}
		prop.setNO(no);
		propService.Delete(prop);
		return "redirect:/property";
	}
//	품목 등록
	@RequestMapping(value = "/regProperty", method = RequestMethod.POST)
	public String PropertyRegister(Property prop) {
		propService.register(prop);
		return "redirect:/property";
	}
//	품목 수정
	@RequestMapping(value = "/Modify", method = RequestMethod.POST)
	public String PropertyModify(Property prop) {
		propService.Modify(prop);
		return "redirect:/property";
	}

}
