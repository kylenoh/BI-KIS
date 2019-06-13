package com.northstar.bi.dto;

public class BoardFile {

	private int FILE_NO;
	private int BOARD_NO;
	private String EMP_ID;
	private String FILE_DUAL;
	private String FILE_NAME;

	public BoardFile() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardFile(int fILE_NO, int bOARD_NO, String eMP_ID, String fILE_DUAL, String fILE_NAME) {
		super();
		FILE_NO = fILE_NO;
		BOARD_NO = bOARD_NO;
		EMP_ID = eMP_ID;
		FILE_DUAL = fILE_DUAL;
		FILE_NAME = fILE_NAME;
	}

	public int getFILE_NO() {
		return FILE_NO;
	}

	public void setFILE_NO(int fILE_NO) {
		FILE_NO = fILE_NO;
	}

	public int getBOARD_NO() {
		return BOARD_NO;
	}

	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getFILE_DUAL() {
		return FILE_DUAL;
	}

	public void setFILE_DUAL(String fILE_DUAL) {
		FILE_DUAL = fILE_DUAL;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	
	
}
