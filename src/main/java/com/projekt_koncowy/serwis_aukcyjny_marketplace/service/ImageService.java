package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ImageModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ProductModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ImageService {

    private ImageRepository imageRepository;

    public List<ImageModel> getAllImages() {
        return imageRepository.findAll();
    }

    public Optional<ImageModel> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public ImageModel saveImage(ImageModel imageModel) {
        return imageRepository.save(imageModel);
    }

    public void deleteImageById(Long id) {
        imageRepository.deleteById(id);
    }

    public void saveImageFile(Long id, MultipartFile file) throws IOException {
        Optional<ImageModel> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            ImageModel imageModel = optionalImage.get();
            imageModel.setImage(file.getBytes());
            imageRepository.save(imageModel);
        } else {
            log.error("Cannot find image with ID: {}", id);
        }
    }

    public byte[] getImageFile(Long id) throws IOException {
        Optional<ImageModel> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            ImageModel imageModel = optionalImage.get();
            return imageModel.getImage();
        } else {
            log.error("Cannot find image with ID: {}", id);
            return null;
        }
    }

    public void deleteImageFile(Long id) {
        Optional<ImageModel> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            ImageModel imageModel = optionalImage.get();
            imageModel.setImage(null);
            imageRepository.save(imageModel);
        } else {
            log.error("Cannot find image with ID: {}", id);
        }
    }
}

