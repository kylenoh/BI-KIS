package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.PropertyDao;
import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired PropertyDao propDao;
	@Override
	public void register(Property prop) {
		propDao.register(prop);
	}
	
	@Override
	public List<Property> getPropertyList(PropertyCriteria criteria) {
		return propDao.getPropertyList(criteria);
	}
	
	@Override
	public int getTotalRows(PropertyCriteria criteria) {
		return propDao.getTotalRows(criteria);
	}
	
	@Override
	public Property getPropertyByNo(int no) {
		return propDao.getPropertyByNo(no);
	}
	@Override
	public void Modify(Property prop) {
		propDao.Modify(prop);
	}
	@Override
	public void Delete(Property prop) {
		propDao.Delete(prop);
	}
}


