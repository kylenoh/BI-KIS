package com.northstar.bi.dao;

import com.northstar.bi.dto.BI_File;
import com.northstar.bi.dto.Board;


public interface BoardDao {
	void insertBoard(Board board);
	void insertBoardtoFile(BI_File biFile);
}
