package com.northstar.bi.dto;

public class Auth {

	private int no;
	private String name;
	private String content;
	
	public Auth() {
		// TODO Auto-generated constructor stub
	}

	public Auth(int no, String name, String content) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
