package com.northstar.bi.service;

import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.BI_File;
import com.northstar.bi.dto.Board;

public interface BoardService {
	void insertBoardtoFile(Board board,BI_File biFile,MultipartFile uploadfile);
	void insertBoard(Board board);
}
