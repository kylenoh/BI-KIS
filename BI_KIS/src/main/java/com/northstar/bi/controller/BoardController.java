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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.BoardReply;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.service.BoardReplyService;
import com.northstar.bi.service.BoardService;
import com.northstar.bi.service.FileService;


@Controller
public class BoardController {

	@Autowired BoardService boardService;
	@Autowired BoardReplyService replyService;
	@Autowired FileService fileService;
//	게시판 진입 시, 페이지
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
						@RequestParam(name="title", required=false) String title,
						@RequestParam(name="writer", required=false) String writer,
						Model model,BoardCriteria criteria) {
		
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setTITLE(title);
		criteria.setID(writer);
		int totalRows = boardService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);

		List<Board> boards = boardService.getBoardList(criteria);
		model.addAttribute("boards", boards);
		model.addAttribute("pagination", pagination);
		return "board/board";
	}

//	게시글 쓰기 진입
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String BoardWrite() {
		return "board/boardWrite";
	}
//	게시글 디테일 진입
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String BoardDetail(@RequestParam("no") int no,
							  BoardReply reply,Model model) {
		Board board = boardService.getBoardByNo(no);
		List<BoardReply>replys = replyService.getReplyList(no);
		model.addAttribute("Board",board);
		model.addAttribute("replys",replys);
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
	public String Upload(Board board, BoardFile boardFile, HttpSession session, MultipartHttpServletRequest files) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		board.setEMP_ID(User.getId());
		boardService.insertBoard(board,boardFile,files,session);
		return "redirect:/board";
	}
//	수정 서비스 진입
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String Modify(@RequestParam Map<String, String>map,
						 RedirectAttributes redirectAttr,
						 Board board, BoardFile boardFile, HttpSession session, MultipartHttpServletRequest files, HttpServletRequest request) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		board.setUPDATER(User.getId()); 
		
		boardService.updateBoard(board,boardFile,files,session,request);
		return "redirect:/board";
	}
//	삭제 서비스 진입
	@RequestMapping(value="/delete")
	public String Delete(RedirectAttributes redirectAttr,HttpSession session, Model model,int no) {
		boardService.deleteBoard(no);
		return "redirect:/board";
	}
//	파일 삭제
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public @ResponseBody BoardFile repUserAjax(@RequestParam("no") int no) {
		return boardService.deleteFile(no);
	}
//	파일 다운로드
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam("idx")int no,
						BoardFile boardfile,
						 HttpServletResponse response) {
		boardfile.setNO(no);
		fileService.selectFileInfo(boardfile,no,response);
	}
//	댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public @ResponseBody String ReplyWrite(@RequestParam("no")int no,
										   @RequestParam("content")String content,
										   BoardReply reply,Model model,HttpSession session) {
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		reply.setBOARD_NO(no);
		reply.setCONTENT(content);
		reply.setID(User.getId());
		replyService.insertBoardReply(reply);
		String replyNo =Integer.toString(reply.getNO());
		return replyNo;
	}
//	댓글 삭제
	@RequestMapping(value = "/deleteReply", method = RequestMethod.GET)
	public @ResponseBody String deleteReply(@RequestParam("no")int no) {
		replyService.deleteBoardReply(no);
		return "board/boardDetail";
	}
	
}
