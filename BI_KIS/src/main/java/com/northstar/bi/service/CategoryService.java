package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Category;

public interface CategoryService {

	void addCategory(List<String> categoryNameList, String divisionName);
	Category getCategoryByCategoryNo(int categoryNo);
	List<Category> getAllCategoryList();
	List<Category> getCategoryList();
	List<Category> getCateSectionListByDivisionName(String divisionName);
}
