package com.example.productcategoryservice.service;

import com.example.productcategoryservice.dto.ResponseProductDTO;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.exception.ProductNotFoundException;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ResponseProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return productMapper.map(products);
    }

    public ResponseProductDTO getProductById(long id) throws ProductNotFoundException {
        Optional<Product> byId = productRepository.findById(id);
        return productMapper.map(byId);
    }

    public ResponseProductDTO addProduct(ResponseProductDTO responseProductDTO) {
        Product product = Product.builder()
                .title(responseProductDTO.getTitle())
                .count(responseProductDTO.getCount())
                .price(responseProductDTO.getPrice())
                .category(responseProductDTO.getCategory())
                .build();
        productRepository.save(product);
        return productMapper.map(product);
    }

        public ResponseProductDTO updateProduct(long id,ResponseProductDTO responseProductDTO) throws ProductNotFoundException {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not exist with id: " + id));
            product.setTitle(responseProductDTO.getTitle());
            product.setCount(responseProductDTO.getCount());
            product.setPrice(responseProductDTO.getPrice());
            productRepository.save(product);

            return productMapper.map(product);
        }

    public ResponseProductDTO deleteProductById(long id) {
        productRepository.deleteById(id);
        return productMapper.map(id);
    }

    public List<Product> getByCategoryId(long id) {
        return productRepository.findAllByCategoryId(id);
    }

}
