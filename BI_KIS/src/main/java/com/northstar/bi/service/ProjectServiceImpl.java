package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.ProjectDao;
import com.northstar.bi.dto.ConPro;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Project;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void addEmpPro(List<String> empIds) {
		for (String empId : empIds) {
			ConPro conPro = new ConPro();
			conPro.setEmpId(empId);
			projectDao.addEmpPro(conPro);
		}
	}
	@Override
	public List<Project> getProjectList() {
		return projectDao.getProjectList();
	}
	@Override
	public List<Project> getProjectByCriteria(Criteria criteria) {
		return projectDao.getProjectByCriteria(criteria);
	}
	@Override
	public Project getProjectByNo(int pjtNo) {
		return projectDao.getProjectByNo(pjtNo);
	}
	@Override
	public void addProject(Project project) {
		projectDao.addProject(project);
	}
	@Override
	public void modifyProject(Project project) {
		projectDao.modifyProject(project);
	}
	@Override
	public void deleteProject(int pjtNo) {
		projectDao.deleteProject(pjtNo);
	}
	@Override
	public int getProjectCount(Criteria criteria) {
		return projectDao.getProjectCount(criteria);
	}
}
