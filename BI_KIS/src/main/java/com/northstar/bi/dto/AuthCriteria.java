package com.northstar.bi.dto;

public class AuthCriteria {

	private int beginIndex;
	private int endIndex;
	
//	검색 조건
	private String PROP_NAME;
	private String PROP_NO;
	private String EMP_ID;
	private String PROP_FLAG;
	
	public AuthCriteria() {
		
	}

	public AuthCriteria(int beginIndex, int endIndex, String pROP_NAME, String pROP_NO, String eMP_ID,
			String pROP_FLAG) {
		super();
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		PROP_NAME = pROP_NAME;
		PROP_NO = pROP_NO;
		EMP_ID = eMP_ID;
		PROP_FLAG = pROP_FLAG;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public String getPROP_NAME() {
		return PROP_NAME;
	}

	public void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}

	public String getPROP_NO() {
		return PROP_NO;
	}

	public void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getPROP_FLAG() {
		return PROP_FLAG;
	}

	public void setPROP_FLAG(String pROP_FLAG) {
		PROP_FLAG = pROP_FLAG;
	}

	
}