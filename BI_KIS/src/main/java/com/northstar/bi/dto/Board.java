package com.northstar.bi.dto;

import java.util.Date;
import java.util.List;

public class Board {
	private int NO;
	private String EMP_ID;
	private String TITLE;
	private Date CREATE_DATE;
	private String CONTENT;
	private String FLAG;
	private String UPDATER;
	private Date UPDATE_DATE;
	
//	외부 데이터
	private String CATE_NAME;
	private String UPDATE_NAME;
	private String EMP_NAME;

	
	private List<BoardFile> FILES;
	private List<BoardReply> REPLYS;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int nO, String eMP_ID, String tITLE, Date cREATE_DATE, String cONTENT, String fLAG, String uPDATER,
			Date uPDATE_DATE, String cATE_NAME, String uPDATE_NAME, String eMP_NAME, List<BoardFile> fILES,
			List<BoardReply> rEPLYS) {
		super();
		NO = nO;
		EMP_ID = eMP_ID;
		TITLE = tITLE;
		CREATE_DATE = cREATE_DATE;
		CONTENT = cONTENT;
		FLAG = fLAG;
		UPDATER = uPDATER;
		UPDATE_DATE = uPDATE_DATE;
		CATE_NAME = cATE_NAME;
		UPDATE_NAME = uPDATE_NAME;
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

	public String getCATE_NAME() {
		return CATE_NAME;
	}

	public void setCATE_NAME(String cATE_NAME) {
		CATE_NAME = cATE_NAME;
	}

	public String getUPDATE_NAME() {
		return UPDATE_NAME;
	}

	public void setUPDATE_NAME(String uPDATE_NAME) {
		UPDATE_NAME = uPDATE_NAME;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public List<BoardFile> getFILES() {
		return FILES;
	}

	public void setFILES(List<BoardFile> fILES) {
		FILES = fILES;
	}

	public List<BoardReply> getREPLYS() {
		return REPLYS;
	}

	public void setREPLYS(List<BoardReply> rEPLYS) {
		REPLYS = rEPLYS;
	}

	
	
}
