package com.northstar.bi.dto;

public class BoardCriteria {
	private String TITLE;
	private String ID;
	private String CATE;
	
	private int beginIndex; // 조회 시작 번호(db에서 조회할 때 사용)
	private int endIndex; // 조회 끝 번호(db에서 조회할 때 사용)

	public BoardCriteria() {
		// TODO Auto-generated constructor stub
	}

	public BoardCriteria(String tITLE, String iD, String cATE, int beginIndex, int endIndex) {
		super();
		TITLE = tITLE;
		ID = iD;
		CATE = cATE;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCATE() {
		return CATE;
	}

	public void setCATE(String cATE) {
		CATE = cATE;
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
