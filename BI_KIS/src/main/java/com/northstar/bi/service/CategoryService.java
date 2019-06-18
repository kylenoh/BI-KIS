package com.northstar.bi.service;

import java.util.List;

import com.northstar.bi.dto.Category;

public interface CategoryService {

	Category getCategoryByCategoryNo(int categoryNo);
	List<Category> getRequestCategoryList();
}
