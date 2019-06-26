package com.northstar.bi.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.SolutionDao;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.dto.SolutionReply;

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
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		Category Category = (Category) session.getAttribute("HEADER_VALUE");
		solution.setEMP_ID(User.getId());
		solution.setCATE(Category.getCATE_NO());
		solutionDao.insertSolution(solution);	
		addSolutionFile(solution, solutionFile, files, session);
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
		solutionDao.deleteSolutionFileList(solutionNo);
		String requestName;
		String idx;
		int paramValue;
		String uploadPath = "D:\\BISolutionFile\\";
		String storedName;
		String originName;
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		Iterator<String>iterator = files.getFileNames();
		MultipartFile multipartfile = null;
		try {
			while (iterator.hasNext()) {
				multipartfile = files.getFile(iterator.next());
				if (multipartfile.isEmpty() == false) {
					System.out.println("신규파일 추가");
					storedName = getUUID()+"_"+multipartfile.getOriginalFilename();
					originName = multipartfile.getOriginalFilename();
					
						multipartfile.transferTo(new File(uploadPath + storedName));
						solutionFile.setSOLUTION_NO(solution.getNO());
						solutionFile.setID(User.getId());
						solutionFile.setDUAL(storedName);
						solutionFile.setNAME(originName);
						solutionFile.setFLAG("N");
						solutionDao.insertSolutionFile(solutionFile);
				}else {
					System.out.println("기존 파일");
					requestName = multipartfile.getName();
					idx = "IDX_"+requestName.substring(requestName.indexOf("_")+1);
					paramValue = Integer.parseInt(request.getParameter(idx));
					solutionDao.updateSolutionFile(paramValue);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardFile getFileByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SolutionFile> getFileList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SolutionReply> getReplyList(int no) {
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
	public BoardFile selectFileInfo(SolutionFile solutionfile, int no, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	중복방지
	private String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
//	파일추가
	private SolutionFile addSolutionFile(Solution solution, SolutionFile solutionfile, MultipartHttpServletRequest files,
			HttpSession session) {
		String uploadPath = "D:\\BISolutionFile\\";
		String storedName = null;
		String originName = null;
		int solutionIdx = solution.getNO();
		System.out.println(solutionIdx);
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		Iterator<String>iterator = files.getFileNames();
		MultipartFile multipartfile = null;
		File target = new File(uploadPath);

		try {
			if (target.exists() == false) {
				target.mkdirs();
			}
			
			while (iterator.hasNext()) {
				multipartfile = files.getFile(iterator.next());
				if (multipartfile.isEmpty()==false) {
					System.out.println("파일 집어넣기");
					storedName = getUUID()+"_"+multipartfile.getOriginalFilename();
					originName = multipartfile.getOriginalFilename();
					target = new File(uploadPath + storedName);
					multipartfile.transferTo(target);
					solutionfile.setSOLUTION_NO(solutionIdx);
					solutionfile.setID(User.getId());
					solutionfile.setDUAL(storedName);
					solutionfile.setNAME(originName);
					solutionfile.setFLAG("N");
					solutionDao.insertSolutionFile(solutionfile);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return solutionfile;
	}
}
