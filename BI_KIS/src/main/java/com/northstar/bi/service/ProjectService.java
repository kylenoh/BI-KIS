package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Project;

public interface ProjectService {

	List<Project> getProjectList ();
	Project getProjectByNo(int pjtNo);
	void addProject(Project project);
	void updateProject(Project project);
	void deleteProject(int pjtNo);
}
