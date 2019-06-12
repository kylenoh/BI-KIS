package com.northstar.bi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.northstar.bi.dao.BoardDao;
import com.northstar.bi.dto.BI_File;
import com.northstar.bi.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired	BoardDao boardDao;

	@Override
	public void insertBoardtoFile(Board board,BI_File biFile, MultipartFile uploadfile) {
		boardDao.insertBoard(board);
		String saveName = uploadfile.getOriginalFilename();
		try {
			saveName = uploadFile(saveName, uploadfile.getBytes());	//	UUID 호출
			FileOutputStream fos = new FileOutputStream("D:/BIFile/" + saveName); // 파일 내용 작성
			InputStream is = uploadfile.getInputStream();

			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			fos.close();
			biFile.setFILE_DUAL(saveName);
			biFile.setFILE_NAME(uploadfile.getOriginalFilename());
			boardDao.insertBoardtoFile(biFile);
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
}
