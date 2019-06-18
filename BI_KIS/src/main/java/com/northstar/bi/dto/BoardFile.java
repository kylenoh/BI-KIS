package com.northstar.bi.dto;

public class BoardFile {

	private int NO;
	private int BOARD_NO;
	private String ID;
	private String DUAL;
	private String NAME;
	private String FLAG;

	public BoardFile() {
		// TODO Auto-generated constructor stub
	}

	public BoardFile(int nO, int bOARD_NO, String iD, String dUAL, String nAME, String fLAG) {
		super();
		NO = nO;
		BOARD_NO = bOARD_NO;
		ID = iD;
		DUAL = dUAL;
		NAME = nAME;
		FLAG = fLAG;
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

	public String getDUAL() {
		return DUAL;
	}

	public void setDUAL(String dUAL) {
		DUAL = dUAL;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	
	
}
