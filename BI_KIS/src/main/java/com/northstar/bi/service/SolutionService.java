package com.northstar.bi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.dto.SolutionReply;

public interface SolutionService {
//	Insert
	void insertSolution(Solution solution, SolutionFile solutionFile, HttpSession session, MultipartHttpServletRequest files);
//	Select
	int getTotalRows (SolutionCriteria criteria);
	List<Solution> getSolutionList (SolutionCriteria criteria);
	Solution getSolutionByNo (int no);
//	Update
	void updateSolution(Solution solution,SolutionFile solutionFile,MultipartHttpServletRequest files, HttpSession session,HttpServletRequest request);
//	Delete
	void deleteSolution(int no);
//	DeleteFile
	SolutionFile deleteSolutionFile (int no);
	
//	Insert
	void insertSolutionReply(SolutionReply reply);
//	Select
	List<SolutionReply>getSolutionReplybyNo(int no);
//	Delete
	void deleteSolutionReply(int no);
	
//	DownLoad
	SolutionFile selectDownload(SolutionFile solutionfile,int no,HttpServletResponse response);
}
