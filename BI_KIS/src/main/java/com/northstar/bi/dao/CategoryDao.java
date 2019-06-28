package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Category;

public interface CategoryDao {

	Category getLastSectionLevel(String divisionName);
	void addCategory(Category category);
	Category getCategoryByCategoryNo(int categoryNo);
	List<Category> getAllCategoryList();
	List<Category> getCategoryList();
	List<Category> getCateSectionListByDivisionName(String divisionName);
}
