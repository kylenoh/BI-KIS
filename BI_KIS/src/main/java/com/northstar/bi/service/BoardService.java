package com.northstar.bi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;

public interface BoardService {
//	Insert
	void insertBoardtoFile(Board board,BoardFile boardFile,MultipartFile file);
	void insertBoard(Board board);
//	Select
	int getTotalRows (BoardCriteria criteria);
	List<Board> getBoardList (BoardCriteria criteria, int cp);
}
