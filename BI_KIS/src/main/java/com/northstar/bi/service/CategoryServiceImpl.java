package com.northstar.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northstar.bi.dao.CategoryDao;
import com.northstar.bi.dto.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	@Override
	public void addCategory(List<String> categoryNameList, String divisionName) {
		for(String categoryName : categoryNameList) {
			Category category = categoryDao.getLastSectionLevel(divisionName);
			System.out.println("/////////////////////" + divisionName + category.getCATE_SECTION_NAME());
			category.setCATE_SECTION_NAME(categoryName);
			category.setCATE_SECTION_LEVEL(category.getCATE_SECTION_LEVEL() + 1);
			categoryDao.addCategory(category);
		}
	}
	@Override
	public List<Category> getAllCategoryList() {
		return categoryDao.getAllCategoryList();
	}
	@Override
	public Category getCategoryByCategoryNo(int categoryNo) {
		return categoryDao.getCategoryByCategoryNo(categoryNo);
	}
	@Override
	public List<Category> getCateSectionListByDivisionName(String divisionName) {
		return categoryDao.getCateSectionListByDivisionName(divisionName);
	}
	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
