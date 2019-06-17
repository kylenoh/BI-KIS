package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Project;

public interface ProjectService {

	List<Project> getProjectByCriteria (Criteria criteria);
	Project getProjectByNo(int pjtNo);
	void addProject(Project project);
	void modifyProject(Project project);
	void deleteProject(int pjtNo);
	int getProjectCount(Criteria criteria);
}
