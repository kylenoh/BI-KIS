package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.FileDao;
import com.northstar.bi.dto.BoardFile;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired FileDao fileDao;
	
	@Override
	public List<BoardFile> getFileList() {
		return fileDao.getFileList();
	}
	
	@Override
	public BoardFile getFileByNo(int no) {
		return fileDao.getFileByNo(no);
	}
}
