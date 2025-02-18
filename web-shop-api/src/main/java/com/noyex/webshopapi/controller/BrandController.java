package com.noyex.webshopapi.controller;

import com.noyex.webshopdata.DTOs.BrandDTO;
import com.noyex.webshopdata.model.Brand;
import com.noyex.webshopservice.service.IBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping("/add")
    public ResponseEntity<Brand> addBrand(@RequestBody BrandDTO brand){
        return ResponseEntity.ok(brandService.saveBrand(brand));
    }

    @PutMapping("/update/{brandId}")
    public ResponseEntity<Brand> updateBrand(@RequestBody BrandDTO brand, @PathVariable Long brandId){
        return ResponseEntity.ok(brandService.updateBrand(brand, brandId));
    }

    @DeleteMapping("/delete/{brandId}")
    public ResponseEntity<String> deleteBrand(@PathVariable Long brandId){
        brandService.deleteBrand(brandId);
        return ResponseEntity.ok("Brand deleted");
    }

    @GetMapping("/get/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long brandId){
        return ResponseEntity.ok(brandService.getBrandById(brandId));
    }
}
