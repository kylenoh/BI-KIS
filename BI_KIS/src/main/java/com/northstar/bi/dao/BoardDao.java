package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardReply;


public interface BoardDao {
//	Insert
	void insertBoard(Board board);
//	Select
	int getTotalRows (BoardCriteria criteria);
	List<Board> getBoardList (BoardCriteria criteria);
	Board getBoardByNo (int no);
//	Update
	void updateBoard(Board board);
	void updateCnt(int no);
//	Delete
	void deleteBoard(int no);
	
//	Reply
//	Insert
	void insertBoardReply(BoardReply reply);
//	Select
	List<BoardReply> getReplybyNo (int no);
//	Delete
	void deleteBoardReply(int no);
	
}
