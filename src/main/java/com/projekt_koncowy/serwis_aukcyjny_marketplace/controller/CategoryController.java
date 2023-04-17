package com.projekt_koncowy.serwis_aukcyjny_marketplace.controller;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/root")
    public List<CategoryModel> getRootCategories() {
        return categoryService.getRootCategories();
    }

    @GetMapping("/categories/{parentId}")
    public List<CategoryModel> getCategoriesByParentId(@PathVariable Long parentId) {
        return categoryService.getCategoriesByParentId(parentId);
    }

    @GetMapping("/categories/id/{id}")
    public CategoryModel getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

}
