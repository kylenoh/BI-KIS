package com.northstar.bi.dto;

import java.util.ArrayList;

public class Emps {
	private ArrayList<Emp> emps;
	
	public Emps() {
		// TODO Auto-generated constructor stub
	}

	public Emps(ArrayList<Emp> emps) {
		super();
		this.emps = emps;
	}

	public ArrayList<Emp> getEmps() {
		return emps;
	}

	public void setEmps(ArrayList<Emp> emps) {
		this.emps = emps;
	}
	
	
}
