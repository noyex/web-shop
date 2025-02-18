package com.noyex.webshopservice.service;

import com.noyex.webshopdata.DTOs.CategoryDTO;
import com.noyex.webshopdata.model.Category;
import com.noyex.webshopdata.repo.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    @Override
    public Category saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }
        Category category = categoryOptional.get();
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }
}
