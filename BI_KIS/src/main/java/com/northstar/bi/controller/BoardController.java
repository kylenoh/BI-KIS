package com.northstar.bi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.BoardPagination;
import com.northstar.bi.service.BoardService;


@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						Model model,BoardCriteria criteria) {
		List<Board> boards = boardService.getBoardList(criteria, cp);
		int totalRows = boardService.getTotalRows(criteria);
		BoardPagination pagination = new BoardPagination(totalRows, cp, 20);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pagination", pagination);
		return "board/board";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String BoardWrite(Model model) {
		return "board/boardWrite";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String Upload(@RequestParam("uploadtitle") String title,
						 @RequestParam("uploadcontent") String content,
						 @RequestParam("uploadtype") String type,
						 Board board, BoardFile boardFile, HttpSession session, MultipartFile file) {
		
		String User = (String) session.getAttribute("id");
		
		board.setEMP_ID(User);
		board.setBOARD_TITLE(title);
		board.setBOARD_CONTENT(content);
		board.setCATE_NO(type);
		
		if (file.getOriginalFilename().isEmpty()) {
			System.out.println("유첨파일이 없다면");
			boardService.insertBoard(board);
			return "board/board";
		}else {
			System.out.println("유첨파일이 있다면");
			boardService.insertBoardtoFile(board,boardFile,file);
			return "board/board";
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test( Model model) {
		return "board/test";
	}
	



}
