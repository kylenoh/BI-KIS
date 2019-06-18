package com.northstar.bi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
						 Board board, BoardFile boardFile, HttpSession session, MultipartHttpServletRequest files) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		board.setID(User.getName());
		board.setTITLE(title);
		board.setCONTENT(content);
		board.setCATE(type);
		boardService.insertBoard(board,boardFile,files,session);
		return "redirect:/board";
	}
//	수정 서비스 진입
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String Modify(@RequestParam("NO") int no,
						 @RequestParam("TITLE") String title,
						 @RequestParam("CONTENT") String content,
						 @RequestParam("TYPE") String type,
						 @RequestParam Map<String, String>map,
						 Board board, BoardFile boardFile, HttpSession session, MultipartHttpServletRequest files,HttpServletRequest request) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		board.setNO(no);
		board.setCATE(type);
		board.setID(User.getName());
		board.setTITLE(title);
		board.setCONTENT(content);
		board.setUPDATER(User.getName()); 
		
		boardService.updateBoard(board,boardFile,files,session,request);
		return "redirect:/board";
	}
//	삭제 서비스 진입
	@RequestMapping(value="/delete")
	public String Delete(HttpSession session, Model model,int no) {
		boardService.deleteBoard(no);
		return "redirect:/board";
	}
//	파일 삭제
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public @ResponseBody BoardFile repUserAjax(@RequestParam("no") int no) {
		System.out.println("컨트롤러 호출");
		return boardService.deleteFile(no);
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam("idx")int no,
						BoardFile boardfile,
						 HttpServletResponse response) {
		boardfile.setNO(no);
		fileService.selectFileInfo(boardfile,no,response);
	}
}
