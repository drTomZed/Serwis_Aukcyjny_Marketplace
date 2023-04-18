package com.projekt_koncowy.serwis_aukcyjny_marketplace.controller;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.SellerModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.service.SellerService;
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
@RequestMapping(value = "/seller", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/sellers")
    public String getAllSellers(Model model) {
        List<SellerModel> sellerModelList = sellerService.getAllSellers();
        model.addAttribute("sellerModels", sellerModelList);
        return "customervievs/index";
    }

    @GetMapping("/sellers/id/{id}")
    public SellerModel getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping("/add")
    public String addSeller(SellerModel sellerModel) {
        sellerService.saveSeller(sellerModel);
        return "customervievs/index";
    }
}
