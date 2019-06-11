package com.northstar.bi.dto;

public class Board {
	private String BOARD_NO;
	private String CATE_NO;
	private String EMP_ID;
	private String BOARD_TITLE;
	private String BOARD_CREATE_DATE;
	private String BOARD_CONTENT;
	private int BOARD_COUNT;
	private String BOARD_FLAG;
	private String BOARD_UPDATER;
	private String BOARD_UPDATE_DATE;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String bOARD_NO, String cATE_NO, String eMP_ID, String bOARD_TITLE, String bOARD_CREATE_DATE,
			String bOARD_CONTENT, int bOARD_COUNT, String bOARD_FLAG, String bOARD_UPDATER, String bOARD_UPDATE_DATE) {
		super();
		BOARD_NO = bOARD_NO;
		CATE_NO = cATE_NO;
		EMP_ID = eMP_ID;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_CREATE_DATE = bOARD_CREATE_DATE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_COUNT = bOARD_COUNT;
		BOARD_FLAG = bOARD_FLAG;
		BOARD_UPDATER = bOARD_UPDATER;
		BOARD_UPDATE_DATE = bOARD_UPDATE_DATE;
	}

	public String getBOARD_NO() {
		return BOARD_NO;
	}

	public void setBOARD_NO(String bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	public String getCATE_NO() {
		return CATE_NO;
	}

	public void setCATE_NO(String cATE_NO) {
		CATE_NO = cATE_NO;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}

	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}

	public String getBOARD_CREATE_DATE() {
		return BOARD_CREATE_DATE;
	}

	public void setBOARD_CREATE_DATE(String bOARD_CREATE_DATE) {
		BOARD_CREATE_DATE = bOARD_CREATE_DATE;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}

	public int getBOARD_COUNT() {
		return BOARD_COUNT;
	}

	public void setBOARD_COUNT(int bOARD_COUNT) {
		BOARD_COUNT = bOARD_COUNT;
	}

	public String getBOARD_FLAG() {
		return BOARD_FLAG;
	}

	public void setBOARD_FLAG(String bOARD_FLAG) {
		BOARD_FLAG = bOARD_FLAG;
	}

	public String getBOARD_UPDATER() {
		return BOARD_UPDATER;
	}

	public void setBOARD_UPDATER(String bOARD_UPDATER) {
		BOARD_UPDATER = bOARD_UPDATER;
	}

	public String getBOARD_UPDATE_DATE() {
		return BOARD_UPDATE_DATE;
	}

	public void setBOARD_UPDATE_DATE(String bOARD_UPDATE_DATE) {
		BOARD_UPDATE_DATE = bOARD_UPDATE_DATE;
	}
	
	
	
}
