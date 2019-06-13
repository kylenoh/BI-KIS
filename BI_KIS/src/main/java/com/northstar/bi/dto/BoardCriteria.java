package com.northstar.bi.dto;

public class BoardCriteria {
	private String opt;
	private String keyword;
	private String orderby; // 정렬기준 - title, writer, ...
	private String sortby; // 정렬방식 - asc, desc
	private String searchOpt;
	private String status;

	private int beginIndex; // 조회 시작 번호(db에서 조회할 때 사용)
	private int endIndex; // 조회 끝 번호(db에서 조회할 때 사용)

	public BoardCriteria() {
		// TODO Auto-generated constructor stub
	}
	
	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getSortby() {
		return sortby;
	}

	public void setSortby(String sortby) {
		this.sortby = sortby;
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

	public String getSearchOpt() {
		return searchOpt;
	}

	public void setSearchOpt(String searchOpt) {
		this.searchOpt = searchOpt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
