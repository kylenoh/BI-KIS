package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.RequestDao;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Request;

@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	RequestDao requestDao;
	@Override
	public int getRequestNo() {
		return requestDao.getRequestNo();
	}
	@Override
	public void modifyRequest(Request request) {
		requestDao.modifyRequest(request);
	}
	@Override
	public void deleteRequest(int requestNo) {
		requestDao.deleteRequest(requestNo);
	}
	@Override
	public void addRequest(Request request) {
		requestDao.addRequest(request);
	}
	@Override
	public Request getRequestByNo(int requestNo) {
		return requestDao.getRequestByNo(requestNo);
	}
	@Override
	public int getRequestCount(Criteria criteria) {
		return requestDao.getRequestCount(criteria);
	}
	
	@Override
	public List<Request> getRequestByCriteria(Criteria criteria) {
		return requestDao.getRequestByCriteria(criteria);
	}
}
