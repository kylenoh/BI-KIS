package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.BoardReply;


public interface BoardReplyDao {
//	Insert
	void insertBoardReply(BoardReply reply);
//	Select
	List<BoardReply> getReplybyNo (int no);
//	Delete
	void deleteBoardReply(int no);
}
