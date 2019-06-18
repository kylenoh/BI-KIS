package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.BoardFile;

public interface FileDao {
//	Insert
	void insertFile(BoardFile boardfile);
//	SelectFile
	List<BoardFile> getFileList();
	BoardFile getFileByNo(int no);
	BoardFile getFile(int no);
//	Update
	void deleteFileList(int boardNo);
	void updateFile(int fileNo);
//	DeleteFile
	BoardFile deleteFile (int no);
//	Download
	BoardFile selectFileInfo(int no);
}
