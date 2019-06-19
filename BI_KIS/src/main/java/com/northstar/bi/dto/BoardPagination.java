package com.northstar.bi.dto;

public class BoardPagination {

	private int pages;				// 한 화면에 표시할 페이지 번호
	private int rows;				// 한 화면에 표시할 데이터 갯수
	private int cp;					// 현재 페이지번호
	private int cb;					// 현재 블록번호
	private int totalRows;			// 전체 데이터갯수
	private String cate;			// 현재 페이지 명
	
	private int totalPages;			// 전체 페이지 갯수
	private int totalBlocks;		// 전체 블록 갯수
	private int beginPageIndex;		// 시작 페이지 번호(현재 페이지에서...)
	private int endPageIndex;		// 끝 페이지 번호(현재 페이지에서...)
	
	private int beginIndex;			// 조회 시작 번호(db에서 조회할 때 사용)
	private int endIndex;			// 조회 끝 번호(db에서 조회할 때 사용)
	
	public BoardPagination(int totalRows, int cp) {
		this.totalRows = totalRows;
		this.cp = cp;
		this.pages = 5;
		this.rows = 10;
		
		init();
	}
	
	public BoardPagination(int totalRows, int cp, int rows) {
		this.totalRows = totalRows;
		this.cp = cp;
		this.pages = 5;
		this.rows = rows;
		
		init();
	}
	
	public BoardPagination(int totalRows, int cp, int pages, int rows) {
		this.totalRows = totalRows;
		this.cp = cp;
		this.pages = pages;
		this.rows = rows;

		init();
	}
	
	private void init() {
		totalPages = (int) (Math.ceil((double)totalRows/rows));
		totalBlocks = (int) (Math.ceil((double)totalPages/pages));
		
		if (cp <= 0) {
			cp = 1;
		}
		if (cp > totalPages) {
			cp = totalPages;
		}
		
		beginIndex = (cp-1) * rows +1;
		endIndex = cp * rows;
		
		cb = (int) (Math.ceil((double)cp/pages));
		
		beginPageIndex = (cb - 1) * pages +1;
		endPageIndex = cb * pages;
		if (cb == totalBlocks) {
			endPageIndex = totalPages;
		}
		
	}
	

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getCb() {
		return cb;
	}

	public void setCb(int cb) {
		this.cb = cb;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalBlocks() {
		return totalBlocks;
	}

	public void setTotalBlocks(int totalBlocks) {
		this.totalBlocks = totalBlocks;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
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
