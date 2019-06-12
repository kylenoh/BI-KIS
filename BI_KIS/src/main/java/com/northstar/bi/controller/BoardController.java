package com.northstar.bi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.Board;
import com.northstar.bi.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(Model model) {
		return "board/board";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String BoardWrite(Model model) {
		return "board/boardWrite";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String Upload(Board board,MultipartFile uploadfile,HttpServletRequest request) {
		board.setBOARD_TITLE(request.getParameter("uploadtitle"));
		board.setBOARD_CONTENT(request.getParameter("uploadcontent"));
		
		if (uploadfile.getOriginalFilename().isEmpty()) {
			System.out.println("파일이름없음");
			return "board/board";
		}else {
			System.out.println("서비스실행");
			boardService.insertBoardList(board,uploadfile);
			return "board/board";
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test( Model model) {
		return "board/test";
	}
	



}
