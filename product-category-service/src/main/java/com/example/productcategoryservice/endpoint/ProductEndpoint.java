package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.SaveProductDto;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody SaveProductDto saveProductDto){
        return productService.addProduct(saveProductDto);
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody SaveProductDto saveProductDto){
        return productService.updateProduct(saveProductDto);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") long id){
        return productService.deleteProductById(id);
    }
    @GetMapping("/product/byCategory/{id}")
    public List<Product> getAllProductByCategory(@PathVariable long id){
        return productService.getByCategoryId(id);
    }

}
