package com.projekt_koncowy.serwis_aukcyjny_marketplace.controller;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<ProductModel> productModelList = productService.getAllProducts();
        model.addAttribute("productModel", productModelList);
        return "customervievs/index";
    }

    @GetMapping("/products/id/{id}")
    public ProductModel getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public String addProduct(ProductModel productModel) {
        productService.saveProduct(productModel);
        return "customervievs/index";
    }
}
