package com.northstar.bi.dto;

public class SolutionFile {

	private int NO;
	private int SOLUTION_NO;
	private String DUAL;
	private String NAME;
	private String FLAG;
	
	public SolutionFile() {
		// TODO Auto-generated constructor stub
	}

	public SolutionFile(int nO, int sOLUTION_NO, String dUAL, String nAME, String fLAG) {
		super();
		NO = nO;
		SOLUTION_NO = sOLUTION_NO;
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

	public int getSOLUTION_NO() {
		return SOLUTION_NO;
	}

	public void setSOLUTION_NO(int sOLUTION_NO) {
		SOLUTION_NO = sOLUTION_NO;
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
