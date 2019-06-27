package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Category;

public interface CategoryDao {

	Category getCategoryByCategoryNo(int categoryNo);
	List<Category> getAllCategoryList();
	List<Category> getCategoryList();
	List<Category> getCateSectionListByDivisionName(String divisionName);
}
