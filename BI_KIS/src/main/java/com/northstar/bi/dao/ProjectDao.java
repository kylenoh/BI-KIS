package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Project;

public interface ProjectDao {

	List<Project> getProjectList();
	Project getProjectByNo(int pjtNo);
	void addProject(Project project);
	void updateProject(Project project);
	void deleteProject(int pjtNo);
}
