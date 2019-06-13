package com.northstar.bi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.BoardPagination;
import com.northstar.bi.dto.Emp;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired	BoardDao boardDao;

	@Override
	public void insertBoardtoFile(Board board,BoardFile boardFile, MultipartFile file, HttpSession session) {
		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		boardDao.insertBoard(board);
		String saveName = file.getOriginalFilename();
		try {
			saveName = uploadFile(saveName, file.getBytes());	//	UUID 호출
			FileOutputStream fos = new FileOutputStream("D:/BIFile/" + saveName); // 파일 내용 작성
			InputStream is = file.getInputStream();

			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			fos.close();
			boardFile.setID(User.getId());
			boardFile.setDUAL(saveName);
			boardFile.setNAME(file.getOriginalFilename());
			boardDao.insertBoardtoFile(boardFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
	
	private String uploadFile(String upload, byte[]fileData) throws IOException {
		String uploadPath = "D:/BIFile/";
		UUID uuid = UUID.randomUUID();
		String saveName = uuid.toString()+"_"+upload;
		File target = new File(uploadPath,saveName);
		FileCopyUtils.copy(fileData, target);	//임시디렉토리에 저장된 파일을 지정된 디렉토리에 복사
		return saveName;
	}
	
	@Override
	public int getTotalRows(BoardCriteria criteria) {
		return boardDao.getTotalRows(criteria);
	}
	
	@Override
	public List<Board> getBoardList(BoardCriteria criteria, int cp) {
		int totalRows = getTotalRows(criteria);
		
		BoardPagination pagination = new BoardPagination(totalRows, cp, 20);
		
		if (pagination.getBeginIndex() <= 0 ) {
			criteria.setBeginIndex(1);
			criteria.setEndIndex(1);
		} else {
			criteria.setBeginIndex(pagination.getBeginIndex());
			criteria.setEndIndex(pagination.getEndIndex());
		}
		
		List<Board> Boards = boardDao.getBoardList(criteria);
		
		return Boards;
	}
	@Override
	public Board getBoardByNo(int no) {
		return boardDao.getBoardByNo(no);
	}
}
