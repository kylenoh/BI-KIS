package com.northstar.bi.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Board;
import com.northstar.bi.dto.BoardFile;

@Component("BoardFileUtils")
public class BoardFileUtils {
	private static final String UPLOADPATH = "D:\\BIFile\\";

	public List<BoardFile> InsertFileinfo(Board board, MultipartHttpServletRequest files) {
		Iterator<String> iterator = files.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		BoardFile boardfile = null;
		int boardIdx = board.getNO();

		List<BoardFile> list = new ArrayList<BoardFile>();
		try {
			File file = new File(UPLOADPATH);
			if (file.exists() == false) {
				file.mkdirs();
			}
			while (iterator.hasNext()) {
				multipartFile = files.getFile(iterator.next());
				if (multipartFile.isEmpty() == false) {
					boardfile = new BoardFile();
					originalFileName = multipartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					storedFileName = CommonUtils.getUUID() + originalFileExtension;
					file = new File(UPLOADPATH + storedFileName);
					multipartFile.transferTo(file);
					boardfile.setBOARD_NO(boardIdx);
					boardfile.setDUAL(storedFileName);
					boardfile.setNAME(originalFileName);
					boardfile.setFLAG("N");
					list.add(boardfile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BoardFile> updateFileInfo(Board board, MultipartHttpServletRequest files,HttpServletRequest request) {
		Iterator<String> iterator = files.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		String requestName = null; 
		String idx = null;

		BoardFile boardfile = null;
		int boardIdx = board.getNO();
		File file = new File(UPLOADPATH);

		List<BoardFile> list = new ArrayList<BoardFile>();
		try {
			while (iterator.hasNext()) {
				multipartFile = files.getFile(iterator.next());
				if (multipartFile.isEmpty() == false) {
					boardfile = new BoardFile();
					originalFileName = multipartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					storedFileName = CommonUtils.getUUID() + originalFileExtension;
					file = new File(UPLOADPATH + storedFileName);
					multipartFile.transferTo(file);
					boardfile.setBOARD_NO(boardIdx);
					boardfile.setDUAL(storedFileName);
					boardfile.setNAME(originalFileName);
					
					boardfile.setFLAG("N");
					list.add(boardfile);
				} else {
					requestName = multipartFile.getName();
					idx = "IDX_" + requestName.substring(requestName.indexOf("_") + 1);
					int fileNo = Integer.parseInt(request.getParameter(idx));
						boardfile = new BoardFile();
						boardfile.setFLAG("Y");
						boardfile.setNO(fileNo);
						list.add(boardfile);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
