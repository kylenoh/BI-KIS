package com.northstar.bi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.northstar.bi.dto.BoardFile;

public interface FileService {
	List<BoardFile> getFileList();
	BoardFile getFileByNo(int no);
//	DownLoad
	BoardFile selectFileInfo(BoardFile boardfile,int no,HttpServletResponse response);
}
