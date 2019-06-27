package com.northstar.bi.dto;

public class AuthCriteria {

	private int beginIndex;
	private int endIndex;
	
	public AuthCriteria() {
		
	}

	public AuthCriteria(int beginIndex, int endIndex) {
		super();
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
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

	

	
}