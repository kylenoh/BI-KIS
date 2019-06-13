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
import com.northstar.bi.dto.Emp;
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
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail(@RequestParam("NO") int no,
							  Model model) {
		Board board = boardService.getBoardByNo(no);
		System.out.println(board.getTITLE());
		model.addAttribute("Board",board);
		return "board/boardDetail";
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String BoardUpdate(@RequestParam("NO") int no,
							  Model model) {
		Board board = boardService.getBoardByNo(no);
		System.out.println(board.getTITLE());
		model.addAttribute("Board",board);
		return "board/boardModify";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String Upload(@RequestParam("uploadtitle") String title,
						 @RequestParam("uploadcontent") String content,
						 @RequestParam("uploadtype") String type,
						 Board board, BoardFile boardFile, HttpSession session, MultipartFile file) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		board.setID(User.getId());
		board.setTITLE(title);
		board.setCONTENT(content);
		board.setCATE(type);
		if (file.getOriginalFilename().isEmpty()) {
			System.out.println("유첨파일이 없다면");
			boardService.insertBoard(board);
			return "board/board";
		}else {
			System.out.println("유첨파일이 있다면");
			boardService.insertBoardtoFile(board,boardFile,file,session);
			return "board/board";
		}
	}
	
}
