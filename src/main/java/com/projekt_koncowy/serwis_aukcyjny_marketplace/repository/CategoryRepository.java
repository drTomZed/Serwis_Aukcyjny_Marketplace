package com.projekt_koncowy.serwis_aukcyjny_marketplace.repository;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    List<CategoryModel> findByParentIsNull();
    List<CategoryModel> findByParentId(Long parentId);
}