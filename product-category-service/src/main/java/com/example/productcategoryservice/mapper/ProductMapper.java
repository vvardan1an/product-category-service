package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.ResponseProductDTO;
import com.example.productcategoryservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ResponseProductDTO map(Product product);

    List<ResponseProductDTO> map(List<Product> products);

    ResponseProductDTO map(Optional<Product> byId);

    ResponseProductDTO map(Long id);
}
