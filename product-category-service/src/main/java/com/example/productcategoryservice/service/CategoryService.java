package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public ResponseEntity<Category> getCategoryById(long id){
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    public ResponseEntity<?> addCategory(Category category){
        Category saveCat = categoryRepository.save(category);
        return ResponseEntity.ok(saveCat);
    }

    public ResponseEntity<?> updateCategory(Category category) {
        if(category.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        categoryRepository.save(category);
        return ResponseEntity.ok(category);
    }

    public ResponseEntity<?> deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
