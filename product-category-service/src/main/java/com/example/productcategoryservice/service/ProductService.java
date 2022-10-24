package com.example.productcategoryservice.service;

import com.example.productcategoryservice.dto.SaveProductDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public ResponseEntity<Product> getProductById(long id) {
        Optional<Product> byId = productRepository.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    public ResponseEntity<?> addProduct(SaveProductDto saveProductDto) {

        Product product = Product.builder()
                .title(saveProductDto.getTitle())
                .count(saveProductDto.getCount())
                .price(saveProductDto.getPrice())
                .category(saveProductDto.getCategory())
                .build();

        Product saveProd = productRepository.save(product);
        return ResponseEntity.ok(saveProd);
    }

    public ResponseEntity<?> updateProduct(SaveProductDto saveProductDto) {

        Product product = Product.builder()
                .title(saveProductDto.getTitle())
                .count(saveProductDto.getCount())
                .price(saveProductDto.getPrice())
                .category(saveProductDto.getCategory())
                .build();

        if(product.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<?> deleteProductById(long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<Product> getByCategoryId(long id) {
        return productRepository.findAllByCategoryId(id);
    }

}
