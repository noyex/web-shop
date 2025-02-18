package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.ImageDTO;
import com.noyex.webshopdata.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> getAllImages();
    void deleteImage(Long imageId);
    Image saveImage(ImageDTO imageDTO);
    Image updateImage(ImageDTO imageDTO, Long imageId);
}
