package com.northstar.bi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Category;
import com.northstar.bi.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
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
		model.addAttribute("categoryAllList",categoryAllList);
		model.addAttribute("categoryList",categoryList);
		return "category/category";
	}
}
