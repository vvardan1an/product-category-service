package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.SaveCategoryDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody SaveCategoryDto saveCategoryDto){
        return categoryService.addCategory(saveCategoryDto);
    }

    @PutMapping("/category")
    public ResponseEntity<?> updateCategory(@RequestBody SaveCategoryDto saveCategoryDto){
        return categoryService.updateCategory(saveCategoryDto);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") long id){
        return categoryService.deleteCategoryById(id);
    }

}
