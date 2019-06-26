package com.northstar.bi.dto;

import java.sql.Date;

public class BoardReply {
	private int NO;
	private int BOARD_NO;
	private String ID;
	private Date CREATE_DATE;
	private String CONTENT;
	
	private String EMP_NAME;
	
	public BoardReply() {
		// TODO Auto-generated constructor stub
	}

	public BoardReply(int nO, int bOARD_NO, String iD, Date cREATE_DATE, String cONTENT, String eMP_NAME) {
		super();
		NO = nO;
		BOARD_NO = bOARD_NO;
		ID = iD;
		CREATE_DATE = cREATE_DATE;
		CONTENT = cONTENT;
		EMP_NAME = eMP_NAME;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public int getBOARD_NO() {
		return BOARD_NO;
	}

	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(Date cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	
	
	
}
