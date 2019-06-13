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
import com.northstar.bi.service.FileService;


@Controller
public class BoardController {

	@Autowired BoardService boardService;
	@Autowired FileService fileService;
//	게시판 진입 시, 페이지
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						Model model,BoardCriteria criteria) {
		List<Board> boards = boardService.getBoardList(criteria, cp);
		int totalRows = boardService.getTotalRows(criteria);
		BoardPagination pagination = new BoardPagination(totalRows, cp, 5);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pagination", pagination);
		return "board/board";
	}
//	게시글 쓰기 진입
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String BoardWrite(Model model) {
		return "board/boardWrite";
	}
//	게시글 디테일 진입
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail(@RequestParam("NO") int no,
							  Model model) {
		Board board = boardService.getBoardByNo(no);
		model.addAttribute("Board",board);
		return "board/boardDetail";
	}
//	게시글 업데이트 진입
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String BoardUpdate(@RequestParam("NO") int no,
							  Model model) {
		Board board = boardService.getBoardByNo(no);
		model.addAttribute("Board",board);
		return "board/boardModify";
	}
//	추가 서비스 진입
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
			boardService.insertBoard(board);
			return "board/board";
		}else {
			boardService.insertBoardtoFile(board,boardFile,file,session);
			return "board/board";
		}
	}
//	수정 서비스 진입
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String Modify(@RequestParam("NO") int no,
						 @RequestParam("uploadtitle") String title,
						 @RequestParam("uploadcontent") String content,
						 @RequestParam("uploadtype") String type,
						 Board board, BoardFile boardFile, HttpSession session, MultipartFile file) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		board.setID(User.getId());
		board.setTITLE(title);
		board.setCONTENT(content);
		board.setCATE(type);
		if (file.getOriginalFilename().isEmpty()) {
			boardService.insertBoard(board);
			return "board/board";
		}else {
			boardService.insertBoardtoFile(board,boardFile,file,session);
			return "board/board";
		}
	}
//	삭제 서비스 진입
	@RequestMapping(value="/delete")
	public String Delete(HttpSession session, Model model,int no) {
		boardService.deleteBoard(no);
		return "redirect:/board";
	}
	
}
