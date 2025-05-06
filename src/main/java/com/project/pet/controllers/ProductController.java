package com.project.pet.controllers;

import java.util.List;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.request.ProductCreateRequest;
import com.project.pet.dto.response.ProductCreateResponse;
import com.project.pet.dto.response.ProductResponse;
import com.project.pet.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.API_V1_PRODUCT)
@RequiredArgsConstructor
public class ProductController {

        private final ProductService productService;

        @PostMapping
        public ProductCreateResponse createProduct(@RequestBody ProductCreateRequest request) {
                return productService.createProduct(request);
        }

        @GetMapping
        public List<ProductResponse> getAllProducts() {
                return productService.getAllProducts();
        }

        @PutMapping("/{id}")
        public ProductCreateResponse updateProduct(@PathVariable("id") Integer id,
                        @RequestBody ProductCreateRequest request) {
                return productService.updateProduct(id, request);
        }

        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable("id") Integer id) {
                productService.deleteProduct(id);
        }
}
