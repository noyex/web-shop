package com.noyex.webshopdata.repo;

import com.noyex.webshopdata.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAll();
    Brand findByName(String name);
}
