package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.CategoryModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.SellerModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.ImageRepository;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.SellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SellerService sellerService;


    @Test
    void getAllSellers() {
        List<SellerModel> sellerModelList = Arrays.asList(
                new SellerModel(1L, "password1", "email1", "sellerTitle1", null, null, null, null, null, null, null , new ArrayList<>(), null, null, null, null, null),
                new SellerModel(2L, "password2", "email2", "sellerTitle2", null, null, null, null, null, null, null , new ArrayList<>(), null, null, null, null, null),
                new SellerModel(3L, "password3", "email3", "sellerTitle3", null, null, null, null, null, null, null , new ArrayList<>(), null, null, null, null, null)
                );
        when(sellerRepository.findAll()).thenReturn(sellerModelList);

        List<SellerModel> allSellers = sellerService.getAllSellers();

        assertEquals(3, allSellers.size());
    }

    @Test
    void getSellerById() {

        Long sellerId  = 1L;
        SellerModel sellerModel = new SellerModel(3L, "password3", "email3", "sellerTitle3", null, null, null, null, null, null, null , new ArrayList<>(), null, null, null, null, null);
        when(sellerRepository.findById(sellerId )).thenReturn(Optional.of(sellerModel));

        SellerModel sellerById = sellerService.getSellerById(sellerId );

        assertEquals(sellerModel, sellerById);

    }

    @Test
    void saveSeller() {
        SellerModel sellerModel =  new SellerModel(3L, "password3", "email3", "sellerTitle3", null, null, null, null, null, null, null , new ArrayList<>(), null, null, null, null, null);
        when(sellerRepository.save(sellerModel)).thenReturn(sellerModel);

        SellerModel savedSeller = sellerService.saveSeller(sellerModel);

        assertEquals(sellerModel, savedSeller);

    }

    @Test
    void deleteSellerById() {
        Long sellerId = 1L;
        doNothing().when(sellerRepository).deleteById(sellerId);

        sellerService.deleteSellerById(sellerId);

        verify(sellerRepository).deleteById(sellerId);
    }
}