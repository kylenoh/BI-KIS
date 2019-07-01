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
			category.setCATE_SECTION_NAME(categoryName);
			if(category.getCATE_SECTION_LEVEL() != 1) {
				category.setCATE_SECTION_LEVEL(category.getCATE_SECTION_LEVEL() + 1);	
			}
			if(category.getCATE_SECTION_LEVEL() == 1) {
				category.setCATE_SECTION_LEVEL(category.getCATE_SECTION_LEVEL());
			}
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
