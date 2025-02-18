package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.ImageDTO;
import com.noyex.webshopdata.model.Image;
import com.noyex.webshopdata.model.Product;
import com.noyex.webshopdata.repo.ImageRepository;
import com.noyex.webshopdata.repo.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ImageService implements IImageService{

    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    public ImageService(ImageRepository imageRepository, ProductRepository productRepository) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public void deleteImage(Long imageId) {
        imageRepository.deleteById(imageId);
    }

    @Override
    public Image saveImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImageUrl(imageDTO.getImageUrl());
        image.setAltText(imageDTO.getAltText());
        Product product = productRepository.findById(imageDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        image.setProduct(product);
        return imageRepository.save(image);

    }

    @Override
    public Image updateImage(ImageDTO imageDTO, Long imageId) {
        Optional<Image> imageOptional = imageRepository.findById(imageId);
        if (imageOptional.isEmpty()) {
            throw new IllegalArgumentException("Image not found");
        }
        Image image = imageOptional.get();
        image.setImageUrl(imageDTO.getImageUrl());
        image.setAltText(imageDTO.getAltText());
        Product product = productRepository.findById(imageDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        image.setProduct(product);
        return imageRepository.save(image);
    }
}
