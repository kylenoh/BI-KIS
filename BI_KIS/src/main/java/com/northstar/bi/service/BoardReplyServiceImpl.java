package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dto.BoardReply;

@Service
public class BoardReplyServiceImpl implements BoardReplyService{
	@Autowired BoardDao boardDao;
	
	@Override
	public List<BoardReply> getReplyList(int no) {
		return boardDao.getReplybyNo(no);
	}
	
	@Override
	public void insertBoardReply(BoardReply reply) {
		boardDao.insertBoardReply(reply);
	}
	@Override
	public void deleteBoardReply(int no) {
		boardDao.deleteBoardReply(no);
	}
}
