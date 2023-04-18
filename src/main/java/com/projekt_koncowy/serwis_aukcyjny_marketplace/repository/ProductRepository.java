package com.projekt_koncowy.serwis_aukcyjny_marketplace.repository;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}