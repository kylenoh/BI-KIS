package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.ConPro;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Project;

public interface ProjectDao {

	List<Project> getProjectByCompanyNo(int companyNo);
	int getProjectNo();
	void deleteEmpProByProjectNo(int projectNo);
	void deleteEmpPro(ConPro conpro);
	void addEmpPro(ConPro conpro);
	List<Project> getProjectList();
	List<Project> getProjectByCriteria(Criteria criteria);
	Project getProjectByNo(int projectNo);
	void addProject(Project project);
	void modifyProject(Project project);
	void deleteProject(int projectNo);
	int getProjectCount(Criteria criteria);
}
