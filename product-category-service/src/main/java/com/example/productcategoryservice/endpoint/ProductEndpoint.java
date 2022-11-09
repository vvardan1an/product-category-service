package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.ResponseProductDTO;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.exception.ProductNotFoundException;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ResponseProductDTO>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResponseProductDTO> addProduct(@RequestBody ResponseProductDTO saveProductDto) {
        return ResponseEntity.ok(productService.addProduct(saveProductDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> updateProduct(@RequestBody ResponseProductDTO saveProductDto,
                                                            @PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, saveProductDto));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    @GetMapping("/byCategory/{id}")
    public List<Product> getAllProductByCategory(@PathVariable long id) {
        return productService.getByCategoryId(id);
    }

}
