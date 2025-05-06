package com.project.pet.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.project.pet.dto.request.ProductCreateRequest;
import com.project.pet.dto.response.ProductCreateResponse;
import com.project.pet.dto.response.ProductResponse;
import com.project.pet.entities.Product;
import com.project.pet.repositories.ProductRepository;
import com.project.pet.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

        private final ProductRepository productRepository;

        @Override
        public ProductCreateResponse createProduct(ProductCreateRequest request) {

                // Connect database to create product
                Product productCreate = Product.builder()
                                .name(request.getName())
                                .description(request.getDescription())
                                .price(new BigDecimal(request.getPrice()))
                                .original_price(new BigDecimal(request.getOriginal_price()))
                                .stock(request.getStock())
                                .category(request.getCategory())
                                .build();
                productCreate = productRepository.save(productCreate);

                // Return response
                ProductCreateResponse productCreateResponse = ProductCreateResponse.builder()
                                .id(productCreate.getId())
                                .name(productCreate.getName())
                                .description(productCreate.getDescription())
                                .price(productCreate.getPrice())
                                .original_price(productCreate.getOriginal_price())
                                .stock(productCreate.getStock())
                                .category(productCreate.getCategory())
                                .build();
                return productCreateResponse;
        }

        @Override
        public List<ProductResponse> getAllProducts() {

                List<Product> products = productRepository.findAll();
                return products.stream()
                                .map(product -> ProductResponse.builder()
                                                .id(product.getId())
                                                .name(product.getName())
                                                .description(product.getDescription())
                                                .price(product.getPrice())
                                                .stock(product.getStock())
                                                .category(product.getCategory())
                                                .build())
                                .toList();
        }

        @Override
        public ProductCreateResponse updateProduct(Integer id, ProductCreateRequest request) {

                // Check if product exists
                Product product = productRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

                // Connect database to update product
                product.setName(request.getName());
                product.setDescription(request.getDescription());
                product.setPrice(new BigDecimal(request.getPrice()));
                product.setOriginal_price(new BigDecimal(request.getOriginal_price()));
                product.setStock(request.getStock());
                product.setCategory(request.getCategory());
                product = productRepository.save(product);

                // Return response
                return ProductCreateResponse.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .original_price(product.getOriginal_price())
                                .stock(product.getStock())
                                .category(product.getCategory())
                                .build();
        }

        @Override
        public void deleteProduct(Integer id) {
                if (!productRepository.existsById(id)) {
                        throw new RuntimeException("Product not found with id: " + id);
                }
                productRepository.deleteById(id);
        }

}
