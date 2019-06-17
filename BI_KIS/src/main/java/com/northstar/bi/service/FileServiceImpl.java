package com.northstar.bi.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.FileDao;
import com.northstar.bi.dto.BoardFile;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired FileDao fileDao;
	
	@Override
	public List<BoardFile> getFileList() {
		return fileDao.getFileList();
	}
	
	@Override
	public BoardFile getFileByNo(int no) {
		return fileDao.getFileByNo(no);
	}
	
	@Override
	public BoardFile selectFileInfo(BoardFile boardfile,int no,HttpServletResponse response){
		boardfile = fileDao.selectFileInfo(no);
		String storedFileName = boardfile.getDUAL();
		String originalFileName = boardfile.getNAME();
		System.out.println("경로에 저장된 이름"+storedFileName);
		System.out.println("보여주는 명칭"+originalFileName);
		try {
			byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\BIFile\\"+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length); 
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return boardfile;
	}
}
