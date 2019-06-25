package com.northstar.bi.dto;

public class SolutionCriteria {
	private int beginIndex; // 조회 시작 번호(db에서 조회할 때 사용)
	private int endIndex; // 조회 끝 번호(db에서 조회할 때 사용)

	private String categoryName;
	
	public SolutionCriteria() {
		// TODO Auto-generated constructor stub
	}

	public SolutionCriteria(int beginIndex, int endIndex, String categoryName) {
		super();
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.categoryName = categoryName;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	
	

}
