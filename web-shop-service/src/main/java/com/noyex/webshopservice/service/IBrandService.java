package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.BrandDTO;
import com.noyex.webshopdata.model.Brand;
import java.util.List;


public interface IBrandService {
    List<Brand> getAllBrands();
    Brand saveBrand(BrandDTO brandDTO);
    void deleteBrand(Long brandId);
    Brand updateBrand(BrandDTO brandDTO, Long brandId);
}
