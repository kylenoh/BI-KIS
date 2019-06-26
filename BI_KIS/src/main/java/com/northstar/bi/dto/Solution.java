package com.northstar.bi.dto;

import java.util.Date;
import java.util.List;

public class Solution {
	private int NO;
	private String EMP_ID;
	private int CATE;
	private String TITLE;
	private Date CREATE_DATE;
	private String CONTENT;
	private String FLAG;
	private String UPDATER;
	private Date UPDATE_DATE;
	
	private String EMP_NAME;
	
	private List<SolutionFile> FILES;
	private List<SolutionReply> REPLYS;
	
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public Solution(int nO, String eMP_ID, int cATE, String tITLE, Date cREATE_DATE, String cONTENT, String fLAG,
			String uPDATER, Date uPDATE_DATE, String eMP_NAME, List<SolutionFile> fILES, List<SolutionReply> rEPLYS) {
		super();
		NO = nO;
		EMP_ID = eMP_ID;
		CATE = cATE;
		TITLE = tITLE;
		CREATE_DATE = cREATE_DATE;
		CONTENT = cONTENT;
		FLAG = fLAG;
		UPDATER = uPDATER;
		UPDATE_DATE = uPDATE_DATE;
		EMP_NAME = eMP_NAME;
		FILES = fILES;
		REPLYS = rEPLYS;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public int getCATE() {
		return CATE;
	}

	public void setCATE(int cATE) {
		CATE = cATE;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
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

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public String getUPDATER() {
		return UPDATER;
	}

	public void setUPDATER(String uPDATER) {
		UPDATER = uPDATER;
	}

	public Date getUPDATE_DATE() {
		return UPDATE_DATE;
	}

	public void setUPDATE_DATE(Date uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public List<SolutionFile> getFILES() {
		return FILES;
	}

	public void setFILES(List<SolutionFile> fILES) {
		FILES = fILES;
	}

	public List<SolutionReply> getREPLYS() {
		return REPLYS;
	}

	public void setREPLYS(List<SolutionReply> rEPLYS) {
		REPLYS = rEPLYS;
	}

	
	
}
