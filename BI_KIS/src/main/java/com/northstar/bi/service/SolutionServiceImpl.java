package com.northstar.bi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.SolutionDao;
import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;

@Service
public class SolutionServiceImpl implements SolutionService {
	@Autowired SolutionDao solutionDao;
	
	@Override
	public List<Solution> getSolutionList(SolutionCriteria criteria) {
		return solutionDao.getSolutionList(criteria);
	}

	@Override
	public int getTotalRows(SolutionCriteria criteria) {
		return solutionDao.getTotalRows(criteria);
	}
	
	@Override
	public void insertSolution(Solution solution, SolutionFile solutionFile, HttpSession session,
			MultipartHttpServletRequest files) {
		solutionDao.insertSolution(solution, solutionFile, session, files);	
	}
}
