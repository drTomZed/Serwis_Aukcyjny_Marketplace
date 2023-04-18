package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.SellerModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;



    @Test
    void testGetAllProducts() {
        List<ProductModel> products = Arrays.asList(
                new ProductModel(1L, "Product 1", "Description 1", new CategoryModel(), new SellerModel(), new ArrayList<>(), null, null, null, new BigDecimal("100.00"), null, null, 0),
                new ProductModel(2L, "Product 2", "Description 2", new CategoryModel(), new SellerModel(), new ArrayList<>(), null, null, null, new BigDecimal("200.00"), null, null, 0),
                new ProductModel(3L, "Product 3", "Description 3", new CategoryModel(), new SellerModel(), new ArrayList<>(), null, null, null, new BigDecimal("300.00"), null, null, 0)
        );
        when(productRepository.findAll()).thenReturn(products);

        List<ProductModel> allProducts = productService.getAllProducts();

        assertEquals(3, allProducts.size());
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        ProductModel product = new ProductModel(1L, "Product 1", "Description 1", new CategoryModel(), new SellerModel(), new ArrayList<>(), null, null, null, new BigDecimal("100.00"), null, null, 0);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        ProductModel productById = productService.getProductById(productId);

        assertEquals(product, productById);

    }

    @Test
    void testSaveProduct() {
        ProductModel product = new ProductModel(1L, "Product 1", "Description 1", new CategoryModel(), new SellerModel(), new ArrayList<>(), null, null, null, new BigDecimal("100.00"), null, null, 0);
        when(productRepository.save(product)).thenReturn(product);

        ProductModel savedProduct = productService.saveProduct(product);

        assertEquals(product, savedProduct);

    }

    @Test
    void testDeleteProductById() {
        Long productId = 1L;
        doNothing().when(productRepository).deleteById(productId);

        productService.deleteProductById(productId);

        verify(productRepository).deleteById(productId);
    }

}