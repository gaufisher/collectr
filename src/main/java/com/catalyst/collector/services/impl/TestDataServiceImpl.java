package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.TestDataDao;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.TestDataService;

@Service
public class TestDataServiceImpl implements TestDataService {

	@Autowired
	TestDataDao testDataDao;
	
	
	public void setTestDataDao(TestDataDao testDataDao) {
		this.testDataDao = testDataDao;
	}


	@Override
	public List<TestData> getTestData() {
		return testDataDao.getTestData();
	}


	@Override
	public ArrayList<Category> getCategory() {
		
		return testDataDao.getCategory();
	}


	@Override
	public void addCategory(Category category) {
		testDataDao.addCategory(category);
		
	}


	@Override
	public void updateCategory(Category category) {
		testDataDao.updateCategory(category);
		
	}


	@Override
	public void deleteCategory(int id) {
		testDataDao.deleteCategory(id);
		
	}

}
