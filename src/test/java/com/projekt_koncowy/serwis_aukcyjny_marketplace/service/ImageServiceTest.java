package com.projekt_koncowy.serwis_aukcyjny_marketplace.service;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.model.ImageModel;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ExtendWith(MockitoExtension.class)
class ImageServiceTest {
    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageService imageService;

    @Test
    public void testGetAllImages() {
        // given
        ImageModel image1 = new ImageModel(1L, "image1.jpg", "http://example.com/image1.jpg", "http://example.com/image1-thumbnail.jpg", new byte[0], null, null, null);
        ImageModel image2 = new ImageModel(2L, "image2.jpg", "http://example.com/image2.jpg", "http://example.com/image2-thumbnail.jpg", new byte[0], null, null, null);
        List<ImageModel> images = Arrays.asList(image1, image2);
        Mockito.when(imageRepository.findAll()).thenReturn(images);

        // when
        List<ImageModel> result = imageService.getAllImages();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(image1);
        assertThat(result.get(1)).isEqualTo(image2);
    }

    @Test
    public void testGetImageById() {
        // given
        ImageModel image = new ImageModel(1L, "image1.jpg", "http://example.com/image1.jpg", "http://example.com/image1-thumbnail.jpg", new byte[0], null, null, null);
        Mockito.when(imageRepository.findById(1L)).thenReturn(Optional.of(image));

        // when
        Optional<ImageModel> result = imageService.getImageById(1L);

        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(image);
    }

    @Test
    public void testSaveImage() {
        // given
        ImageModel image = new ImageModel(1L, "image1.jpg", "http://example.com/image1.jpg", "http://example.com/image1-thumbnail.jpg", new byte[0], null, null, null);
        Mockito.when(imageRepository.save(image)).thenReturn(image);

        // when
        ImageModel result = imageService.saveImage(image);

        // then
        assertThat(result).isEqualTo(image);
    }

    @Test
    public void testDeleteImageById() {
        // given
        Long id = 1L;

        // when
        imageService.deleteImageById(id);

        // then
        Mockito.verify(imageRepository, Mockito.times(1)).deleteById(id);
    }
}