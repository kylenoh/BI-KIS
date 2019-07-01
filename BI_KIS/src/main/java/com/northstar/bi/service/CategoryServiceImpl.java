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
	public void categoryEvent(Category category) {
		//add
		if(category.getADD_SECTION_NAME_LIST() != null) {
			for(String categoryName : category.getADD_SECTION_NAME_LIST()) {
				Category addCategory = categoryDao.getLastSectionLevel(category.getCATE_DIVISION_NAME());
				addCategory.setCATE_SECTION_NAME(categoryName);
				if(addCategory.getCATE_SECTION_LEVEL() != 1) {
					addCategory.setCATE_SECTION_LEVEL(addCategory.getCATE_SECTION_LEVEL() + 1);	
				}
				if(addCategory.getCATE_SECTION_LEVEL() == 1) {
					addCategory.setCATE_SECTION_LEVEL(addCategory.getCATE_SECTION_LEVEL());
				}
				categoryDao.addCategory(addCategory);
			}
		}
		//update
		if(category.getCATE_NO_LIST() != null) {
			for(int categoryNo : category.getCATE_NO_LIST()) {
				for(String categorySectionName : category.getSECTION_NAME_LIST()) {
					Category updateCategory = categoryDao.getCategoryByCategoryNo(categoryNo);
					updateCategory.setCATE_SECTION_NAME(categorySectionName);
					categoryDao.modifyCategory(updateCategory);
					break;
				}
			}
		}
		//delete
		if(category.getDEL_CATE_NO_LIST() != null) {
			for(int categoryNo : category.getDEL_CATE_NO_LIST()) {
				Category updatecategory = categoryDao.getCategoryByCategoryNo(categoryNo);
				categoryDao.deleteCategory(categoryNo);
				categoryDao.updateSectionLevel(updatecategory);
			}
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
