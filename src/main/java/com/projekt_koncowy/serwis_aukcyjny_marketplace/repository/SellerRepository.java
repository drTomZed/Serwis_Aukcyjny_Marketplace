package com.projekt_koncowy.serwis_aukcyjny_marketplace.repository;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerModel, Long> {
}