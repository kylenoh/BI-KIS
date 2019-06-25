package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Category;

public interface CategoryDao {

	List<Category> getCategoryList();
	List<Category> getCateSectionListByDivisionName(String divisionName);
}
