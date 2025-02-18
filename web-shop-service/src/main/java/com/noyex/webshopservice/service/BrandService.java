package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.BrandDTO;
import com.noyex.webshopdata.model.Brand;
import com.noyex.webshopdata.repo.BrandRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BrandService implements IBrandService{

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long brandId) {
        brandRepository.deleteById(brandId);
    }

    @Override
    public Brand updateBrand(BrandDTO brandDTO, Long brandId) {
        Optional<Brand> brandOptional = brandRepository.findById(brandId);
        if (brandOptional.isEmpty()) {
            throw new IllegalArgumentException("Brand not found");
        }
        Brand brand = brandOptional.get();
        brand.setName(brandDTO.getName());
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        Optional<Brand> brandOptional = brandRepository.findById(brandId);
        if (brandOptional.isEmpty()) {
            throw new IllegalArgumentException("Brand not found");
        }
        return brandOptional.get();
    }
}
