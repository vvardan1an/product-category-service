package com.example.productcategoryservice.service;

import com.example.productcategoryservice.dto.ResponseCategoryDTO;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.exception.CategoryNotFoundException;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public List<ResponseCategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.map(categories);
    }

    public ResponseCategoryDTO getCategoryById(long id) throws CategoryNotFoundException {
        Optional<Category> byId = categoryRepository.findById(id);
        return categoryMapper.map(byId);
    }

    public ResponseCategoryDTO addCategory(ResponseCategoryDTO saveCategoryDto) {
        Category category = Category.builder()
                .name(saveCategoryDto.getName())
                .build();
        categoryRepository.save(category);
        return categoryMapper.map(category);
    }

    public ResponseCategoryDTO updateCategory(long id,ResponseCategoryDTO responseCategoryDTO) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not exist with id: " + id));
        category.setName(responseCategoryDTO.getName());
        categoryRepository.save(category);

        return categoryMapper.map(category);
    }

    public ResponseCategoryDTO deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
        return categoryMapper.map(id);
    }
}
