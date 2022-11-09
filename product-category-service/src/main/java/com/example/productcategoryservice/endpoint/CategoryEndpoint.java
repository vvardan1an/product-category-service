package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.ResponseCategoryDTO;
import com.example.productcategoryservice.dto.UpdateCategoryDTO;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.exception.CategoryNotFoundException;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<ResponseCategoryDTO>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategoryDTO> getCategoryById(@PathVariable("id") long id) throws CategoryNotFoundException {
        try {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        }catch (CategoryNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResponseCategoryDTO> addCategory(@RequestBody ResponseCategoryDTO saveCategoryDto){
        return ResponseEntity.ok(categoryService.addCategory(saveCategoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCategoryDTO> updateCategory(@RequestBody ResponseCategoryDTO responseCategoryDTO,
                                            @PathVariable("id") long id){
        try {
            return ResponseEntity.ok(categoryService.updateCategory(id, responseCategoryDTO));
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") long id){
        return ResponseEntity.ok(categoryService.deleteCategoryById(id));
    }

}
