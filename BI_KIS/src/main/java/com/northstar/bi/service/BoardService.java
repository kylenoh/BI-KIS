package com.northstar.bi.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;

}
