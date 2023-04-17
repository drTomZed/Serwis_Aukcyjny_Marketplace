package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryModel> getRootCategories() {
        return categoryRepository.findByParentIsNull();
    }

    public List<CategoryModel> getCategoriesByParentId(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }

    public void addCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryModel getCategoryById(Long id) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        if (categoryModel.isPresent()) {
            return categoryRepository.findById(id).orElse(null);
        } else {
            log.info("brak takiej kategorii");
            return null;
        }
    }

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }


    public void saveEditCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);

    }


}
