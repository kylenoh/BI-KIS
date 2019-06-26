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

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.dto.SolutionReply;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.SolutionService;

@Controller
public class SolutionController {
	
	@Autowired SolutionService solutionService;	
	@Autowired CategoryService categoryService;
	
	@RequestMapping(value = "/solution", method = RequestMethod.GET)
	public String Solution(@RequestParam(name="cp", required=false, defaultValue="1") int cp,
				     	   @RequestParam(name="title", required=false) String title,
						   @RequestParam(name="writer", required=false) String writer,
						   @RequestParam(name="cateNo", required = false, defaultValue = "0")int cateNo,
						Model model,SolutionCriteria criteria,HttpSession session) {
		
		Category category = new Category();
		if(cateNo == 0) {
			category = (Category)session.getAttribute("HEADER_VALUE");
		}
		if(cateNo != 0) {
			category = categoryService.getCategoryByCategoryNo(cateNo);
		}
		session.setAttribute("HEADER_VALUE", category);
		int rows = 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setCategoryName(category.getCATE_SECTION_NAME());
		criteria.setTITLE(title);
		criteria.setID(writer);
		int totalRows = solutionService.getTotalRows(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Solution>solutions = solutionService.getSolutionList(criteria);
		
		
		model.addAttribute("solutions",solutions);
		model.addAttribute("pagination", pagination);
		
		return "solution/solution";
	}
	
	@RequestMapping(value = "/solutionWrite", method = RequestMethod.GET)
	public String SolutionWrite() {
		return "solution/solutionWrite";
	}
	
	@RequestMapping(value = "/solutionUpload", method = RequestMethod.POST)
	public String solutionUpload(Solution solution, SolutionFile solutionFile, HttpSession session, MultipartHttpServletRequest files) {
		solutionService.insertSolution(solution, solutionFile, session, files);
		return "redirect:/solution";
	}
	
	@RequestMapping(value = "/solutionDetail", method = RequestMethod.GET)
	public String BoardDetail(@RequestParam("no") int no,
							  Model model) {
		Solution solution = solutionService.getSolutionByNo(no);
		List<SolutionReply>replys = solutionService.getReplyList(no);
		model.addAttribute("solution",solution);
		model.addAttribute("replys",replys);
		return "solution/solutionDetail";
	}
	@RequestMapping(value = "/solutionUpdate", method = RequestMethod.POST)
	public String SolutionUpdate(@RequestParam("NO") int no,
							  Model model) {
		Solution solution = solutionService.getSolutionByNo(no);
		model.addAttribute("solution",solution);
		return "solution/solutionModify";
	}
	@RequestMapping(value = "/solutionModify", method = RequestMethod.POST)
	public String SolutionModify(@RequestParam Map<String, String>map,
						 RedirectAttributes redirectAttr,
						 Solution solution, SolutionFile solutionFile, HttpSession session, MultipartHttpServletRequest files, HttpServletRequest request) {
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		solution.setUPDATER(User.getId());
		solutionService.updateSolution(solution, solutionFile, files, session, request);
		return "redirect:/solution";
	}
//	삭제 서비스 진입
	@RequestMapping(value="/solutionDelete")
	public String SolutionDelete(RedirectAttributes redirectAttr,HttpSession session, Model model,int no) {
		solutionService.deleteSolution(no);
		return "redirect:/solution";
	}
//	파일 삭제
	@RequestMapping(value="/solutionDeleteFile", method=RequestMethod.POST)
	public @ResponseBody SolutionFile SolutionDeleteFile(@RequestParam("no") int no) {
		return solutionService.deleteSolutionFile(no);
		
	}
//	파일 다운로드
	@RequestMapping(value = "/solutionDownload", method = RequestMethod.GET)
	public void SolutionDownload(@RequestParam("idx")int no,
						SolutionFile solutionfile,
						 HttpServletResponse response) {
		solutionfile.setSOLUTION_NO(no);
		solutionService.selectDownload(solutionfile, no, response);
	}
//	댓글 작성
	@RequestMapping(value = "/solutionReplyWrite", method = RequestMethod.POST)
	public @ResponseBody String SolutionReplyWrite(@RequestParam("no")int no,
										   @RequestParam("content")String content,
										   SolutionReply reply,Model model,HttpSession session) {
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		reply.setSOLUTION_NO(no);
		reply.setCONTENT(content);
		reply.setID(User.getId());
		solutionService.insertSolutionReply(reply);
		String replyNo = Integer.toString(reply.getNO());
		return replyNo;
	}
//	댓글 삭제
	@RequestMapping(value = "/solutionDeleteReply", method = RequestMethod.POST)
	public @ResponseBody String SolutionDeleteReply(@RequestParam("no")int no) {
		System.out.println(no);
		solutionService.deleteSolutionReply(no);
		String replyNo = Integer.toString(no);
		return replyNo;
	}
	
}
