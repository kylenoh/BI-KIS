package com.northstar.bi.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dao.FileDao;
import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.Emp;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;
	@Autowired
	FileDao fileDao;

//	게시판 추가
	@Override
	public void insertBoard(Board board, BoardFile boardfile, MultipartHttpServletRequest files, HttpSession session) {
		boardDao.insertBoard(board);
		addFile(board, boardfile, files, session);
	}

//	페이지 전체 카운트
	@Override
	public int getTotalRows(BoardCriteria criteria) {
		return boardDao.getTotalRows(criteria);
	}

//	페이지 된 게시판 출력
	@Override
	public List<Board> getBoardList(BoardCriteria criteria) {
		return boardDao.getBoardList(criteria);

	}

//	특정 게시판 출력
	@Override
	public Board getBoardByNo(int no) {
		boardDao.updateCnt(no);
		return boardDao.getBoardByNo(no);
	}

//	게시판 업데이트
	@Override
	public void updateBoard(Board board, BoardFile boardfile, MultipartHttpServletRequest files, HttpSession session,HttpServletRequest request) {
		boardDao.updateBoard(board);	//일반 게시글 업데이트
		int boardNo = board.getNO();	
		
		fileDao.deleteFileList(boardNo);	//존재하는 첨부파일의 상태를 Y로 삭제

		List<Map<String, Object>>list = updateFile(board, boardfile, files, session, request);
		Map<String, Object>temp = null;
		
		for (int i = 0; i < list.size(); i++) {	//리스트 크기만큼 반복을 돌면서
			temp = list.get(i);
			if (temp.get("FILE_FLAG").equals("Y")) {	//	전부 Y로 INSERT하고
				System.out.println("기존존재하던 파일");
				fileDao.updateFile(boardfile.getNO());
			}else {										//	INSERT할것이 없으면 N으로 변경
				fileDao.insertFile(boardfile);			
			}
		}

	}

//	게시글 삭제
	@Override
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}

//	파일 선택
	private BoardFile getFile(int no) {
		return fileDao.getFile(no);
	}

//	파일 삭제
	@Override
	public BoardFile deleteFile(int no) {
		String Path = "D:\\BIFile\\";
		BoardFile selectFile = getFile(no);
		File file = new File(Path + selectFile.getDUAL());
		if (file.exists()) {
			System.out.println("실물지우기");
			file.delete();
		}
		return fileDao.deleteFile(no);
	}
//	파일추가
	private BoardFile addFile(Board board, BoardFile boardfile, MultipartHttpServletRequest files,
			HttpSession session) {
		String uploadPath = "D:\\BIFile\\";
		String storedName = null;
		String originName = null;
		int boardIdx = board.getNO();
		
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
					storedName = getRandom()+"_"+multipartfile.getOriginalFilename();
					originName = multipartfile.getOriginalFilename();
					target = new File(uploadPath + storedName);
					multipartfile.transferTo(target);
					boardfile.setBOARD_NO(boardIdx);
					boardfile.setID(User.getId());
					boardfile.setDUAL(storedName);
					boardfile.setNAME(originName);
					boardfile.setFLAG("N");
					fileDao.insertFile(boardfile);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardfile;
	}
//	중복방지
	private String getRandom() {
		return UUID.randomUUID().toString().replace("-", "");
	}
//	업데이트 로직
	private List<Map<String, Object>>updateFile(Board board, BoardFile boardfile, MultipartHttpServletRequest files, HttpSession session,HttpServletRequest request){
		String uploadPath = "D:\\BIFile\\";
		String storedName = null;
		String originName = null;
		String requestName = null;
		String idx = null;
		String paramValue = null;
		int param = 0;
		
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		Iterator<String>iterator = files.getFileNames();
		MultipartFile multipartfile = null;
		List<Map<String, Object>>list = new ArrayList<Map<String,Object>>();
		Map<String, Object>listmap = null;
		
		while (iterator.hasNext()) {
			multipartfile = files.getFile(iterator.next());
			if (multipartfile.isEmpty()==false) {
				storedName = getRandom()+"_"+multipartfile.getOriginalFilename();
				originName = multipartfile.getOriginalFilename();
				try {
					multipartfile.transferTo(new File(uploadPath + storedName));
					boardfile.setBOARD_NO(board.getNO());
					boardfile.setID(User.getId());
					boardfile.setDUAL(storedName);
					boardfile.setNAME(originName);
					boardfile.setFLAG("N");
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				listmap = new HashMap<String, Object>();
				listmap.put("BOARD_NO", board.getNO());
				listmap.put("EMP_ID", User.getId());
				listmap.put("FILE_DUAL", storedName);
				listmap.put("FILE_NAME", originName);
				listmap.put("FILE_FLAG", "N");
				list.add(listmap);
			}else {	// 추가된 파일이 없다면 
				requestName = multipartfile.getName();
				idx = "IDX_"+requestName.substring(requestName.indexOf("_")+1);
				paramValue = request.getParameter(idx);
				param = Integer.parseInt(paramValue);
				System.out.println(idx+":"+paramValue);
					boardfile.setNO(param);
					listmap = new HashMap<String,Object>();
					listmap.put("FILE_NO", paramValue);
					listmap.put("FILE_FLAG", "Y");
					list.add(listmap);
			}
		}
		
		return list;
		
	}
	

}
