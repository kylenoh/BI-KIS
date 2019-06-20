package com.northstar.bi.dto;

import java.sql.Date;

public class Property {
	private int NO;
	private String ID;
	private String PROP_NAME;
	private String CODE;
	private Date DATE;
	private String REMARK;
	private Date BUY_DATE;
	
	public Property() {
		// TODO Auto-generated constructor stub
	}

	public Property(int nO, String iD, String pROP_NAME, String cODE, Date dATE, String rEMARK, Date bUY_DATE) {
		super();
		NO = nO;
		ID = iD;
		PROP_NAME = pROP_NAME;
		CODE = cODE;
		DATE = dATE;
		REMARK = rEMARK;
		BUY_DATE = bUY_DATE;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPROP_NAME() {
		return PROP_NAME;
	}

	public void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public Date getDATE() {
		return DATE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public Date getBUY_DATE() {
		return BUY_DATE;
	}

	public void setBUY_DATE(Date bUY_DATE) {
		BUY_DATE = bUY_DATE;
	}

	
}
