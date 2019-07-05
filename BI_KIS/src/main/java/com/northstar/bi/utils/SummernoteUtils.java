package com.northstar.bi.utils;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("SummernoteUtils")
public class SummernoteUtils {
	private final static String saveDirectory = "C:/upload";
	
	public String saveFile(MultipartFile mf)throws Exception {
		String fileName = CommonUtils.getUUID() + "-" + mf.getOriginalFilename();
		String filepath = saveDirectory + "\\" + fileName;
		File f = new File(filepath);
		if( !f.exists()) {
			f.mkdirs();
		}
		mf.transferTo(f);
		return "upload/"+ fileName;
	}
}
