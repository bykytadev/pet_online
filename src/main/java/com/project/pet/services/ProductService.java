package com.project.pet.services;

import java.util.List;

import com.project.pet.dto.request.ProductCreateRequest;
import com.project.pet.dto.response.ProductCreateResponse;
import com.project.pet.dto.response.ProductResponse;

public interface ProductService {

    ProductCreateResponse createProduct(ProductCreateRequest request);

    List<ProductResponse> getAllProducts();

    ProductCreateResponse updateProduct(Integer id, ProductCreateRequest request);

    void deleteProduct(Integer id);
}
