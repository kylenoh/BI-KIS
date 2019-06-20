package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.BoardReplyDao;
import com.northstar.bi.dto.BoardReply;

@Service
public class BoardReplyServiceImpl implements BoardReplyService{
	@Autowired BoardReplyDao replyDao;
	
	@Override
	public List<BoardReply> getReplyList(int no) {
		return replyDao.getReplybyNo(no);
	}
	
	@Override
	public void insertBoardReply(BoardReply reply) {
		replyDao.insertBoardReply(reply);
	}
	@Override
	public void deleteBoardReply(int no) {
		replyDao.deleteBoardReply(no);
	}
}
