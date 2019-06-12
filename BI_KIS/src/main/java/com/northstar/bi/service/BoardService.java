package com.northstar.bi.service;

import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dto.Board;

public interface BoardService {
	void insertBoardList(Board board,MultipartFile uploadfile);

}
