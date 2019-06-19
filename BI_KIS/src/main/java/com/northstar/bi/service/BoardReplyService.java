package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.BoardReply;

public interface BoardReplyService {
//	Insert
	void insertBoardReply(BoardReply reply);
//	Select
	List<BoardReply>getReplyList(int no);
//	Delete
	void deleteBoardReply(int no);
}
