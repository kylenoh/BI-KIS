package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Project;

public interface ProjectService {

	List<Project> getProjectByCompanyNo(int companyNo);
	int getProjectNo();
	void deleteEmpProByProjectNo(int projectNo);
	void deleteEmpPro(List<String> empId, int projectNo);
	void addEmpPro(List<String> empId,int projectNo);
	List<Project> getProjectList();
	List<Project> getProjectByCriteria (Criteria criteria);
	Project getProjectByNo(int projectNo);
	void addProject(Project project);
	void modifyProject(Project project);
	void deleteProject(int projectNo);
	int getProjectCount(Criteria criteria);
}
