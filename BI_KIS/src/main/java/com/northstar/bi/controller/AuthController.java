package com.northstar.bi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Auth;
import com.northstar.bi.dto.AuthCriteria;
import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.service.AuthService;
import com.northstar.bi.service.CategoryService;

@Controller
public class AuthController {

	@Autowired AuthService authService;
	@Autowired CategoryService categoryService;
	
//	페이징
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String Authorization(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
						Model model,AuthCriteria criteria,HttpSession session) {
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
		
		int totalRows = authService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Auth>auths = authService.getAuthList(criteria);
		model.addAttribute("auths", auths);
		model.addAttribute("pagination", pagination);
		
		return "auth/auth";
	}

}
