package com.projekt_koncowy.serwis_aukcyjny_marketplace.controller;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/category", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<CategoryModel> categoryModelList = categoryService.getAllCategories();
        model.addAttribute("categoryModel", categoryModelList);
        return "customervievs/index";
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

    @PostMapping("/add")
    public String addCategory(@RequestParam("name") String name, @RequestParam("parentId") Long parentId) {
        CategoryModel category = new CategoryModel();
        category.setCategoryName(name);

        if (parentId != null) {
            Optional<CategoryModel> parentCategory = Optional.ofNullable(categoryService.getCategoryById(parentId));
            if (parentCategory.isPresent()) {
                category.setParent(parentCategory.get());
            }
        }

        categoryService.addCategory(category);
        return "redirect:/";

    }
}
