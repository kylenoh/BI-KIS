package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;


public interface BoardDao {
//	Insert
	void insertBoard(Board board);
	void insertBoardtoFile(BoardFile boardFile);
//	Select
	int getTotalRows (BoardCriteria criteria);
	List<Board> getBoardList (BoardCriteria criteria);
	Board getBoardByNo (int no);
//	Update
	void updateBoard(Board board);
//	Delete
	void deleteBoard(int no);
}
