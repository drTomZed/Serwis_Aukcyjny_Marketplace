package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCategories() {
        List<CategoryModel> expectedCategories = new ArrayList<>();
        expectedCategories.add(new CategoryModel(1L, null, "Category 1", null, null,null, null,null, null));
        expectedCategories.add(new CategoryModel(2L, null, "Category 2", null, null,null, null,null, null));
        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<CategoryModel> actualCategories = categoryService.getAllCategories();

        verify(categoryRepository, times(1)).findAll();
        Assertions.assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void testGetRootCategories() {
        List<CategoryModel> expectedCategories = new ArrayList<>();
        expectedCategories.add(new CategoryModel(1L, null, "Category 1", null, null,null, null,null, null));
        expectedCategories.add(new CategoryModel(2L, null, "Category 2", null, null,null, null,null, null));
        when(categoryRepository.findByParentIsNull()).thenReturn(expectedCategories);

        List<CategoryModel> actualCategories = categoryService.getRootCategories();

        verify(categoryRepository, times(1)).findByParentIsNull();
        Assertions.assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void testGetCategoriesByParentId() {
        Long parentId = 1L;
        List<CategoryModel> expectedCategories = new ArrayList<>();
        expectedCategories.add(new CategoryModel(1L, null, "Category 1", null, null,null, null,null, null));
        expectedCategories.add(new CategoryModel(2L, null, "Category 2", null,  null,null, null,null, null));
        when(categoryRepository.findByParentId(parentId)).thenReturn(expectedCategories);

        List<CategoryModel> actualCategories = categoryService.getCategoriesByParentId(parentId);

        verify(categoryRepository, times(1)).findByParentId(parentId);
        Assertions.assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void testGetCategoryById() {
        Long categoryId = 1L;
        CategoryModel expectedCategory = new CategoryModel(categoryId,  null, "Category 1", null,  null,null, null,null, null);
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(expectedCategory));

        CategoryModel actualCategory = categoryService.getCategoryById(categoryId);

        verify(categoryRepository, times(2)).findById(categoryId);
        Assertions.assertEquals(expectedCategory, actualCategory);
    }
}