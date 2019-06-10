package com.northstar.bi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String main(HttpSession session, Model model) {
		String test = "Å×½ºÆ®";
		model.addAttribute("test",test);
		return "main";
	}
}
