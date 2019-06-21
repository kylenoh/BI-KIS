package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.ConPro;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Project;

public interface ProjectDao {

	int getProjectNo();
	void deleteEmpPro(ConPro conpro);
	void addEmpPro(ConPro conpro);
	List<Project> getProjectList();
	List<Project> getProjectByCriteria(Criteria criteria);
	Project getProjectByNo(int pjtNo);
	void addProject(Project project);
	void modifyProject(Project project);
	void deleteProject(int pjtNo);
	int getProjectCount(Criteria criteria);
}
