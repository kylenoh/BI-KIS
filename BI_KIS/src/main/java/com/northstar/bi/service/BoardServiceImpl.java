package com.northstar.bi.service;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardDao boardDao;
	
	@Override
	public void insertBoardList(Board board, MultipartFile uploadfile) {
		String upload = uploadfile.getOriginalFilename();
		try {
			FileOutputStream fos = new FileOutputStream("D:/BIFile/" + upload);	//파일 내용 작성
			InputStream is = uploadfile.getInputStream();
			
			int readCount = 0;
			byte[]buffer = new byte[1024];
			while ((readCount = is.read(buffer))!= -1) {
				fos.write(buffer,0,readCount);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			boardDao.insertBoardList(board);
		}
		
	}

}
