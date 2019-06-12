package com.northstar.bi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.BI_File;
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
	public String Upload(Board board,BI_File biFile, MultipartFile uploadfile,HttpServletRequest request) {
		board.setBOARD_TITLE(request.getParameter("uploadtitle"));
		board.setBOARD_CONTENT(request.getParameter("uploadcontent"));
		board.setCATE_NO(request.getParameter("uploadtype"));
		
		if (uploadfile.getOriginalFilename().isEmpty()) {
			System.out.println("유첨파일이 없다면");
			boardService.insertBoard(board);
			return "board/board";
		}else {
			System.out.println("유첨파일이 있다면");
			boardService.insertBoardtoFile(board,biFile,uploadfile);
			return "board/board";
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test( Model model) {
		return "board/test";
	}
	



}
