package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;

public interface PropertyDao {
//	Insert
	void register(Property prop);
	
//	Select
	int getTotalRows (PropertyCriteria criteria);
	List<Property> getPropertyList (PropertyCriteria criteria);
	Property getPropertyByNo(int no);
//	Update
	void  Modify(Property prop);
	void Delete(Property prop);
}
