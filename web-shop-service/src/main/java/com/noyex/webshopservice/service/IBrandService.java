package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.BrandDTO;
import com.noyex.webshopdata.model.Brand;
import java.util.List;
import java.util.Optional;


public interface IBrandService {
    List<Brand> getAllBrands();
    Brand saveBrand(BrandDTO brandDTO);
    void deleteBrand(Long brandId);
    Brand updateBrand(BrandDTO brandDTO, Long brandId);
    Brand getBrandById(Long brandId);
}
