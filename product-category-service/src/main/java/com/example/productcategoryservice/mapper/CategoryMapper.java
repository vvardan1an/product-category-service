package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.ResponseCategoryDTO;
import com.example.productcategoryservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    ResponseCategoryDTO map(Category category);

    List<ResponseCategoryDTO> map(List<Category> categories);

    ResponseCategoryDTO map(Optional<Category> byId);

    ResponseCategoryDTO map(Long id);
}
