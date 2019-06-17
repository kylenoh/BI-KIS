package com.northstar.bi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;

public interface BoardService {
//	Insert
	void insertBoard(Board board,BoardFile boardfile,MultipartHttpServletRequest files,HttpSession session);
//	Select
	int getTotalRows (BoardCriteria criteria);
	List<Board> getBoardList (BoardCriteria criteria, int cp);
	Board getBoardByNo (int no);
//	Update
	void updateBoard(Board board);
	void updateBoardtoFile(Board board,BoardFile boardFile,MultipartHttpServletRequest files, HttpSession session);
//	Delete
	void deleteBoard(int no);
//	DeleteFile
	BoardFile deleteFile (int no);


}
