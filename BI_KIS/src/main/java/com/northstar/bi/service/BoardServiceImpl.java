package com.northstar.bi.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dao.FileDao;
import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardCriteria;
import com.northstar.bi.dto.BoardFile;
import com.northstar.bi.dto.BoardPagination;
import com.northstar.bi.dto.Emp;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardDao boardDao;
	@Autowired FileDao fileDao;

//	유첨 파일 추가
	@Override
	public void insertBoardtoFile(Board board,BoardFile boardFile, MultipartHttpServletRequest files, HttpSession session) {
		List<MultipartFile>fileList = files.getFiles("file");
		String uploadPath = "D:\\BIFile\\";
		String saveName = null;
		String dualName = null;
		UUID uuid = UUID.randomUUID();
		File target = new File(uploadPath);

		Emp User = (Emp) session.getAttribute("LOGIN_EMP");
		
		boardDao.insertBoard(board);
		try {
			for (int i = 0; i < fileList.size(); i++) {
				dualName = uuid.toString()+"_"+fileList.get(i).getOriginalFilename();
				saveName = fileList.get(i).getOriginalFilename();		//원본명
				target = new File(uploadPath+dualName);	//중복방지명
				fileList.get(i).transferTo(target);
				System.out.println(saveName);
				boardFile.setNAME(saveName);
				boardFile.setDUAL(dualName);
				boardFile.setID(User.getId());
				boardDao.insertBoardtoFile(boardFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	무첨 파일 추가
	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
//	페이지 전체 카운트
	@Override
	public int getTotalRows(BoardCriteria criteria) {
		return boardDao.getTotalRows(criteria);
	}
//	페이지 된 게시판 출력
	@Override
	public List<Board> getBoardList(BoardCriteria criteria, int cp) {
		int totalRows = getTotalRows(criteria);
		
		BoardPagination pagination = new BoardPagination(totalRows, cp, 5);
		
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
//	특정 게시판 출력
	@Override
	public Board getBoardByNo(int no) {
		return boardDao.getBoardByNo(no);
	}
//	게시판 업데이트
	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	@Override
	public void updateBoardtoFile(Board board, BoardFile boardFile, MultipartHttpServletRequest files,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}
//	게시글 삭제
	@Override
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}
//	파일 선택
	private BoardFile getFile(int no) {
		return fileDao.getFile(no);
	}
//	파일 삭제
	@Override
	public BoardFile deleteFile(int no) {
		String Path = "D:\\BIFile\\";
		BoardFile selectFile = getFile(no);
		System.out.println(selectFile.getDUAL());
		File file = new File(Path+selectFile.getDUAL());
        if(file.exists()) {
        	System.out.println("실물지우기");
            file.delete();
        }
		return fileDao.deleteFile(no);
	}
}

