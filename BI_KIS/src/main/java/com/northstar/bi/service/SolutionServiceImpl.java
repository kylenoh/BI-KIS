package com.northstar.bi.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.SolutionDao;
import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.dto.SolutionReply;
import com.northstar.bi.utils.SolutionFileUtils;

@Service
public class SolutionServiceImpl implements SolutionService {
	@Autowired SolutionDao solutionDao;
	@Resource(name="SolutionFileUtils") private SolutionFileUtils solutionUtils;
	
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
		Category Category = (Category) session.getAttribute("HEADER_VALUE");
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		solution.setEMP_ID(User.getId());
		solution.setCATE(Category.getCATE_NO());
		solutionDao.insertSolution(solution);
		
		List<SolutionFile> list = solutionUtils.InsertFileinfo(solution, files);
		for (int i = 0; i < list.size(); i++) {
			solutionDao.insertSolutionFile(list.get(i));
		}
	}
	@Override
	public void deleteSolution(int no) {
		solutionDao.deleteSolution(no);
	}
	@Override
	public SolutionFile deleteSolutionFile(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Solution getSolutionByNo(int no) {
		return solutionDao.getSolutionByNo(no);
	}
	
	@Override
	public void updateSolution(Solution solution, SolutionFile solutionFile, MultipartHttpServletRequest files,
			HttpSession session, HttpServletRequest request) {
		solutionDao.updateSolution(solution);	//일반 게시글 업데이트
		int solutionNo = solution.getNO();
		solutionDao.deleteSolutionFileList(solutionNo);		// 플래그 N -> Y 로 변경
		String temp = null;
		List<SolutionFile>list = solutionUtils.updateFileInfo(solution, files,request);
		for (int i = 0; i < list.size(); i++) {
				temp = list.get(i).getFLAG();
			if (temp.equals("N")) {
				solutionDao.insertSolutionFile(list.get(i));
			}else {
				solutionDao.updateSolutionFile(list.get(i).getNO());
			}
		}

	}

	@Override
	public List<SolutionReply> getSolutionReplybyNo(int no) {
		return solutionDao.getSolutionReplybyNo(no);
	}
	
	@Override
	public void deleteSolutionReply(int no) {
		solutionDao.deleteSolutionReply(no);
	}
	
	@Override
	public void insertSolutionReply(SolutionReply reply) {
		solutionDao.insertSolutionReply(reply);
	}
	
	@Override
	public SolutionFile selectDownload(SolutionFile solutionfile, int no, HttpServletResponse response) {
		solutionfile = solutionDao.selectDownload(no);
		String storedFileName = solutionfile.getDUAL();
		String originalFileName = solutionfile.getNAME();
		try {
			byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\BISolutionFile\\"+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length); 
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return solutionfile;
	}
	

}
