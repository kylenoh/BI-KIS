package com.northstar.bi.dto;

import java.util.Date;

public class Solution {
	private int SOLUTION_NO;
	private String EMP_ID;
	private String SOLUTION_CATE;
	private String SOLUTION_TITLE;
	private Date SOLUTION_CREATE_DATE;
	private String SOLUTION_CONTENT;
	private String SOLUTION_FLAG;
	private String SOLUTION_UPDATER;
	private Date SOLUTION_UPDATE_DATE;
	
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public Solution(int sOLUTION_NO, String eMP_ID, String sOLUTION_CATE, String sOLUTION_TITLE,
			Date sOLUTION_CREATE_DATE, String sOLUTION_CONTENT, String sOLUTION_FLAG, String sOLUTION_UPDATER,
			Date sOLUTION_UPDATE_DATE) {
		super();
		SOLUTION_NO = sOLUTION_NO;
		EMP_ID = eMP_ID;
		SOLUTION_CATE = sOLUTION_CATE;
		SOLUTION_TITLE = sOLUTION_TITLE;
		SOLUTION_CREATE_DATE = sOLUTION_CREATE_DATE;
		SOLUTION_CONTENT = sOLUTION_CONTENT;
		SOLUTION_FLAG = sOLUTION_FLAG;
		SOLUTION_UPDATER = sOLUTION_UPDATER;
		SOLUTION_UPDATE_DATE = sOLUTION_UPDATE_DATE;
	}

	public int getSOLUTION_NO() {
		return SOLUTION_NO;
	}

	public void setSOLUTION_NO(int sOLUTION_NO) {
		SOLUTION_NO = sOLUTION_NO;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getSOLUTION_CATE() {
		return SOLUTION_CATE;
	}

	public void setSOLUTION_CATE(String sOLUTION_CATE) {
		SOLUTION_CATE = sOLUTION_CATE;
	}

	public String getSOLUTION_TITLE() {
		return SOLUTION_TITLE;
	}

	public void setSOLUTION_TITLE(String sOLUTION_TITLE) {
		SOLUTION_TITLE = sOLUTION_TITLE;
	}

	public Date getSOLUTION_CREATE_DATE() {
		return SOLUTION_CREATE_DATE;
	}

	public void setSOLUTION_CREATE_DATE(Date sOLUTION_CREATE_DATE) {
		SOLUTION_CREATE_DATE = sOLUTION_CREATE_DATE;
	}

	public String getSOLUTION_CONTENT() {
		return SOLUTION_CONTENT;
	}

	public void setSOLUTION_CONTENT(String sOLUTION_CONTENT) {
		SOLUTION_CONTENT = sOLUTION_CONTENT;
	}

	public String getSOLUTION_FLAG() {
		return SOLUTION_FLAG;
	}

	public void setSOLUTION_FLAG(String sOLUTION_FLAG) {
		SOLUTION_FLAG = sOLUTION_FLAG;
	}

	public String getSOLUTION_UPDATER() {
		return SOLUTION_UPDATER;
	}

	public void setSOLUTION_UPDATER(String sOLUTION_UPDATER) {
		SOLUTION_UPDATER = sOLUTION_UPDATER;
	}

	public Date getSOLUTION_UPDATE_DATE() {
		return SOLUTION_UPDATE_DATE;
	}

	public void setSOLUTION_UPDATE_DATE(Date sOLUTION_UPDATE_DATE) {
		SOLUTION_UPDATE_DATE = sOLUTION_UPDATE_DATE;
	}

	
	
	
}
