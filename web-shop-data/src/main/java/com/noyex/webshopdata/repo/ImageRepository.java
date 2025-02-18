package com.noyex.webshopdata.repo;

import com.noyex.webshopdata.model.Image;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository {
    List<Image> findAll();
    void deleteById(Long imageId);
    Image save(Image image);
    Optional<Image> findById(Long imageId);
}
