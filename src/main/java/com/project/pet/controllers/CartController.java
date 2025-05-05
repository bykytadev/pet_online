package com.project.pet.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.request.ProductRequest;
import com.project.pet.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.API_V1_CART)
public class CartController {

    // Giả sử giỏ hàng cho 1 user (userId = 1)
    private static final Map<Integer, List<ProductResponse>> cart = new HashMap<>();

    @PostMapping("/add")
    public String addToCart(@RequestBody ProductRequest request) {

        int userId = 1;
        cart.putIfAbsent(userId, new ArrayList<>());

        ProductResponse product = new ProductResponse(
                null,
                request.getName(),
                request.getDescription(),
                request.getPrice() != null ? new BigDecimal(request.getPrice()) : null,
                request.getStock(),
                request.getOriginal_price() != null ? new BigDecimal(request.getOriginal_price()) : null,
                request.getCategory());
        cart.get(userId).add(product);

        return "Product added to cart successfully!";
    }
}
