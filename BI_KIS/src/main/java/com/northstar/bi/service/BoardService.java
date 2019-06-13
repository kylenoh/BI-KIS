package com.northstar.bi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;

public interface BoardService {
//	Insert
	void insertBoardtoFile(Board board,BoardFile boardFile,MultipartFile file, HttpSession session);
	void insertBoard(Board board);
//	Select
	int getTotalRows (BoardCriteria criteria);
	List<Board> getBoardList (BoardCriteria criteria, int cp);
	Board getBoardByNo (int no);
//	Update
	void updateBoard(Board board);
//	Delete
	void deleteBoard(int no);
}
