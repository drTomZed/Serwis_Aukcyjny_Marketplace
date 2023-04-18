package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.SellerModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class SellerService {

    private SellerRepository sellerRepository;

    public List<SellerModel> getAllSellers() {
        return sellerRepository.findAll();
    }

    public SellerModel getSellerById(Long id) {
        Optional<SellerModel> sellerModel = sellerRepository.findById(id);
        if (sellerModel.isPresent()) {
            return sellerRepository.findById(id).orElse(null);
        } else {
            log.info("brak takiego sprzedawcy");
            return null;
        }
    }

    public SellerModel saveSeller(SellerModel sellerModel) {
        return sellerRepository.save(sellerModel);
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }

}
