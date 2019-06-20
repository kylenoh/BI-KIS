package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Property;
import com.northstar.bi.dto.PropertyCriteria;

public interface PropertyService {

	void register(Property prop);
	
	int getTotalRows (PropertyCriteria criteria);
	List<Property> getPropertyList (PropertyCriteria criteria);
}
