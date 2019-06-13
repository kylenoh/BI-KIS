package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.BoardFile;

public interface FileDao {
	List<BoardFile> getFileList();
	BoardFile getFileByNo(int no);
}
