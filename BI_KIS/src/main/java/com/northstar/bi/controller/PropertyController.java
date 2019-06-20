package com.northstar.bi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;
import com.northstar.bi.service.PropertyService;

@Controller
public class PropertyController {

	@Autowired PropertyService propService;
	
//	페이징
	@RequestMapping(value = "/property", method = RequestMethod.GET)
	public String Board(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						Model model,PropertyCriteria criteria) {
		
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
	public String BoardWrite() {
		return "property/propertyWrite";
	}
//	품목 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Register(Property prop) {
		propService.register(prop);
		return "redirect:/property";
	}
}
