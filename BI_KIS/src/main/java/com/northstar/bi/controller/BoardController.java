package com.northstar.bi.controller;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(Model model) {
		return "board/board";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String BoardWrite(Model model) {
		return "board/boardWrite";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		return "board/test";
	}

	@RequestMapping(value = "/sample/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandmap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
//		BoardService.insertBoard(commandmap.getmap(), request);
		return mv;
	}

}
