package com.northstar.bi.dto;

public class Property {
	private int NO;
	private String ID;
	private String PROP_NAME;
	private String CODE;
	private String PROP_DATE;
	private String REMARK;
	private String BUY_DATE;
	private String FLAG;

	public Property() {
		// TODO Auto-generated constructor stub
	}

	public Property(int nO, String iD, String pROP_NAME, String cODE, String pROP_DATE, String rEMARK, String bUY_DATE,
			String fLAG) {
		super();
		NO = nO;
		ID = iD;
		PROP_NAME = pROP_NAME;
		CODE = cODE;
		PROP_DATE = pROP_DATE;
		REMARK = rEMARK;
		BUY_DATE = bUY_DATE;
		FLAG = fLAG;
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

	public String getPROP_DATE() {
		return PROP_DATE;
	}

	public void setPROP_DATE(String pROP_DATE) {
		PROP_DATE = pROP_DATE;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public String getBUY_DATE() {
		return BUY_DATE;
	}

	public void setBUY_DATE(String bUY_DATE) {
		BUY_DATE = bUY_DATE;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	

}
