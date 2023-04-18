package com.projekt_koncowy.serwis_aukcyjny_marketplace.controller;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ImageModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/images", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ImageController {
    private ImageService imageService;

    @GetMapping("")
    public ResponseEntity<List<ImageModel>> getAllImages() {
        List<ImageModel> images = imageService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageModel> getImageById(@PathVariable Long id) {
        Optional<ImageModel> image = imageService.getImageById(id);
        return image.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<ImageModel> createImage(@RequestBody ImageModel imageModel) {
        ImageModel savedImage = imageService.saveImage(imageModel);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        imageService.deleteImageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
