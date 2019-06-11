package com.northstar.bi.service;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
//	@Resource(name = "fileUtils")
//	private FileUtils fileUtils;

	@Resource(name = "boardDao")
	private BoardDao boardDao;

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
//		sampleDAO.insertBoard(map);
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
//				log.debug("------------- file start -------------");
//				log.debug("name : " + multipartFile.getName());
//				log.debug("filename : " + multipartFile.getOriginalFilename());
//				log.debug("size : " + multipartFile.getSize());
//				log.debug("-------------- file end --------------\n");
			}
		}
	}

}
