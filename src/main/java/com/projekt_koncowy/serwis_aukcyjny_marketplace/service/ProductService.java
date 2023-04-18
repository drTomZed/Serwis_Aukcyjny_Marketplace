package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ImageModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductModel getProductById(Long id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isPresent()) {
            return productRepository.findById(id).orElse(null);
        } else {
            log.info("brak takiego produktu");
            return null;
        }
    }

    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
