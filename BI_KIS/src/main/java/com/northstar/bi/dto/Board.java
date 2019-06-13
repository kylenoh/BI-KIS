package com.northstar.bi.dto;

import java.util.List;

public class Board {
	private String NO;
	private String CATE;
	private String ID;
	private String TITLE;
	private String CREATE_DATE;
	private String CONTENT;
	private int COUNT;
	private String FLAG;
	private String UPDATER;
	private String UPDATE_DATE;
	
//	외부 데이터
	private List<BoardFile>FILES;
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String nO, String cATE, String iD, String tITLE, String cREATE_DATE, String cONTENT, int cOUNT,
			String fLAG, String uPDATER, String uPDATE_DATE, List<BoardFile> fILES) {
		super();
		NO = nO;
		CATE = cATE;
		ID = iD;
		TITLE = tITLE;
		CREATE_DATE = cREATE_DATE;
		CONTENT = cONTENT;
		COUNT = cOUNT;
		FLAG = fLAG;
		UPDATER = uPDATER;
		UPDATE_DATE = uPDATE_DATE;
		FILES = fILES;
	}

	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public String getCATE() {
		return CATE;
	}

	public void setCATE(String cATE) {
		CATE = cATE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public int getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
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

	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}

	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}

	public List<BoardFile> getFILES() {
		return FILES;
	}

	public void setFILES(List<BoardFile> fILES) {
		FILES = fILES;
	}

}
