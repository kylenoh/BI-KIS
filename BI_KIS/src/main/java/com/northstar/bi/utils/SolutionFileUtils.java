package com.northstar.bi.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionFile;

@Component("SolutionFileUtils")
public class SolutionFileUtils {
	private static final String UPLOADPATH = "D:\\\\BISolutionFile\\\\";

	public List<SolutionFile> InsertFileinfo(Solution solution, MultipartHttpServletRequest files) {
		Iterator<String> iterator = files.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		SolutionFile solutionfile = null;
		int solutionIdx = solution.getNO();

		List<SolutionFile> list = new ArrayList<SolutionFile>();
		try {
			File file = new File(UPLOADPATH);
			if (file.exists() == false) {
				file.mkdirs();
			}
			while (iterator.hasNext()) {
				multipartFile = files.getFile(iterator.next());
				if (multipartFile.isEmpty() == false) {
					solutionfile = new SolutionFile();
					originalFileName = multipartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					storedFileName = CommonUtils.getUUID() + originalFileExtension;
					file = new File(UPLOADPATH + storedFileName);
					multipartFile.transferTo(file);
					solutionfile.setSOLUTION_NO(solutionIdx);
					solutionfile.setDUAL(storedFileName);
					solutionfile.setNAME(originalFileName);
					solutionfile.setFLAG("N");
					list.add(solutionfile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<SolutionFile> updateFileInfo(Solution solution, MultipartHttpServletRequest files,HttpServletRequest request) {
		Iterator<String> iterator = files.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		String requestName = null; 
		String idx = null;

		SolutionFile solutionfile = null;
		int solutionIdx = solution.getNO();

		List<SolutionFile> list = new ArrayList<SolutionFile>();
		try {
			while (iterator.hasNext()) {
				multipartFile = files.getFile(iterator.next());
				if (multipartFile.isEmpty() == false) {
					System.out.println("신규파일");
					originalFileName = multipartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					storedFileName = CommonUtils.getUUID() + originalFileExtension;
					multipartFile.transferTo(new File(UPLOADPATH + storedFileName));
					solutionfile = new SolutionFile();
					solutionfile.setSOLUTION_NO(solutionIdx);
					solutionfile.setDUAL(storedFileName);
					solutionfile.setNAME(originalFileName);
					solutionfile.setFLAG("N");
					list.add(solutionfile);
				} else {
					System.out.println("기존파일");
					requestName = multipartFile.getName();
					idx = "IDX_" + requestName.substring(requestName.indexOf("_") + 1);
					int fileNo = Integer.parseInt(request.getParameter(idx));
					System.out.println(fileNo);
						solutionfile = new SolutionFile();
						solutionfile.setFLAG("Y");
						solutionfile.setSOLUTION_NO(fileNo);
						list.add(solutionfile);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
