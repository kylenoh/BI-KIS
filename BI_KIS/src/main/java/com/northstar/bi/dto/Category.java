package com.northstar.bi.dto;

import java.util.List;

public class Category {

	private int CATE_NO;
	private String CATE_DIVISION_NAME;
	private int CATE_DIVISION_LEVEL; 
	private String CATE_SECTION_NAME;
	private int CATE_SECTION_LEVEL;
	private String CATE_VALUE;
	private int CATE_AUTH_NO;

	private List<String> SECTION_NAME_LIST;
	private List<Integer> CATE_NO_LIST;
	private List<String> ADD_SECTION_NAME_LIST;
	private List<Integer> DEL_CATE_NO_LIST;
	public Category() {}

	public int getCATE_NO() {
		return CATE_NO;
	}

	public void setCATE_NO(int cATE_NO) {
		CATE_NO = cATE_NO;
	}

	public String getCATE_DIVISION_NAME() {
		return CATE_DIVISION_NAME;
	}

	public void setCATE_DIVISION_NAME(String cATE_DIVISION_NAME) {
		CATE_DIVISION_NAME = cATE_DIVISION_NAME;
	}

	public int getCATE_DIVISION_LEVEL() {
		return CATE_DIVISION_LEVEL;
	}

	public void setCATE_DIVISION_LEVEL(int cATE_DIVISION_LEVEL) {
		CATE_DIVISION_LEVEL = cATE_DIVISION_LEVEL;
	}

	public String getCATE_SECTION_NAME() {
		return CATE_SECTION_NAME;
	}

	public void setCATE_SECTION_NAME(String cATE_SECTION_NAME) {
		CATE_SECTION_NAME = cATE_SECTION_NAME;
	}

	public int getCATE_SECTION_LEVEL() {
		return CATE_SECTION_LEVEL;
	}

	public void setCATE_SECTION_LEVEL(int cATE_SECTION_LEVEL) {
		CATE_SECTION_LEVEL = cATE_SECTION_LEVEL;
	}

	public String getCATE_VALUE() {
		return CATE_VALUE;
	}

	public void setCATE_VALUE(String cATE_VALUE) {
		CATE_VALUE = cATE_VALUE;
	}

	public int getCATE_AUTH_NO() {
		return CATE_AUTH_NO;
	}

	public void setCATE_AUTH_NO(int cATE_AUTH_NO) {
		CATE_AUTH_NO = cATE_AUTH_NO;
	}

	public List<String> getSECTION_NAME_LIST() {
		return SECTION_NAME_LIST;
	}

	public void setSECTION_NAME_LIST(List<String> sECTION_NAME_LIST) {
		SECTION_NAME_LIST = sECTION_NAME_LIST;
	}

	public List<Integer> getCATE_NO_LIST() {
		return CATE_NO_LIST;
	}

	public void setCATE_NO_LIST(List<Integer> cATE_NO_LIST) {
		CATE_NO_LIST = cATE_NO_LIST;
	}

	public List<String> getADD_SECTION_NAME_LIST() {
		return ADD_SECTION_NAME_LIST;
	}

	public void setADD_SECTION_NAME_LIST(List<String> aDD_SECTION_NAME_LIST) {
		ADD_SECTION_NAME_LIST = aDD_SECTION_NAME_LIST;
	}

	public List<Integer> getDEL_CATE_NO_LIST() {
		return DEL_CATE_NO_LIST;
	}

	public void setDEL_CATE_NO_LIST(List<Integer> dEL_CATE_NO_LIST) {
		DEL_CATE_NO_LIST = dEL_CATE_NO_LIST;
	}

	
}
