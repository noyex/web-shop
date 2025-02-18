package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.CategoryDTO;
import com.noyex.webshopdata.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category saveCategory(CategoryDTO categoryDTO);
    void deleteCategory(Long categoryId);
    Category updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
