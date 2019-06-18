package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Request;

public interface RequestService {

	void modifyRequest(Request request);
	void deleteRequest(int requestNo);
	void addRequest(Request request);
	Request getRequestByNo(int requestNo);
	int getRequestCount(Criteria criteria);
	List<Request> getRequestByCriteria(Criteria criteria);
}
