/*
package com.example.demo.model;

import com.example.demo.dao.CategoryDao;
import com.example.demo.service.CategoryService;
import org.junit.jupiter.api;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    @Test
    public void testFetchAllCategory(){
//        Given
        List<Category> expectedCategories = new  ArrayList<>();
        expectedCategories.add(new Category(1,"cat1"));
        expectedCategories.add(new Category(2,"cat2"));
        CategoryDao categoryDaoMocked = Mockito.mock(CategoryDao.class);
        Mockito.when(categoryDaoMocked.findAll()).thenReturn(expectedCategories);
//        When
        CategoryService categoryService = new CategoryService();
        categoryService.setCategoryDao(categoryDaoMocked);
        List<Category> categoryResult = categoryService.fetchAllCategory1();


//        Then
        Assertions.assertEquals(expectedCategories,categoryResult);
    }

}*/
