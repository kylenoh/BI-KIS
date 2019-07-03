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
import com.northstar.bi.service.AuthService;
import com.northstar.bi.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired 
	AuthService authService;
	@RequestMapping(value="category")
	public String category(@RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
							HttpSession session, Model model) {
		Category category = new Category();
		if(cateNo == 0) {
			category = (Category)session.getAttribute("HEADER_VALUE");
		}
		if(cateNo != 0) {
			category = categoryService.getCategoryByCategoryNo(cateNo);
		}
		session.setAttribute("HEADER_VALUE", category);
		List<Category> categoryAllList = categoryService.getAllCategoryList();
		List<Category> categoryList = categoryService.getCategoryList();
		List<Auth> auths = authService.getAuthList();
		
		model.addAttribute("categoryAllList",categoryAllList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("auths",auths);
		return "category/category";
	}
	@RequestMapping(value="categoryEvent", method=RequestMethod.POST)
	public String categoryEvent(Category category) {
		
		categoryService.categoryEvent(category);
		return "redirect:/category";
	}
	@RequestMapping(value="categoryAuthUpdate")
	@ResponseBody
	public String categoryAuthUpdate(Category category) {
		categoryService.modifyCategoryAuthNo(category);
		return "";
	}
}
