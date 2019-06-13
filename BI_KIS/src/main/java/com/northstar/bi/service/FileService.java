package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.BoardFile;

public interface FileService {
	List<BoardFile> getFileList();
	BoardFile getFileByNo(int no);
}
