package com.northstar.bi.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;

public interface SolutionDao {
//	Insert
	void insertSolution(Solution solution, SolutionFile solutionFile, HttpSession session, MultipartHttpServletRequest files);
//	Select
	int getTotalRows (SolutionCriteria criteria);
	List<Solution> getSolutionList (SolutionCriteria criteria);
}
