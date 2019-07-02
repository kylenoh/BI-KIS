package com.northstar.bi.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
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
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.utils.BoardFileUtils;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired	BoardDao boardDao;
	@Autowired	FileDao fileDao;
	@Resource(name="BoardFileUtils") private BoardFileUtils boardUtils;
	
//	게시판 추가
	@Override
	public void insertBoard(Board board, BoardFile boardfile, MultipartHttpServletRequest files, HttpSession session) {
		boardDao.insertBoard(board);
		List<BoardFile> list = boardUtils.InsertFileinfo(board, files);
		for (int i = 0; i < list.size(); i++) {
			fileDao.insertFile(list.get(i));
		}
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
		return boardDao.getBoardByNo(no);
	}

//	게시판 업데이트
	@Override
	public void updateBoard(Board board, BoardFile boardfile, MultipartHttpServletRequest files, HttpSession session,HttpServletRequest request) {
		boardDao.updateBoard(board);	//일반 게시글 업데이트
		int boardNo = board.getNO();	
		fileDao.deleteFileList(boardNo);
		
		String temp = null;
		List<BoardFile>list = boardUtils.updateFileInfo(board, files,request);
		for (int i = 0; i < list.size(); i++) {
				temp = list.get(i).getFLAG();
			if (temp.equals("N")) {
				fileDao.insertFile(list.get(i));
			}else {
				fileDao.updateFile(list.get(i).getNO());
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


}
