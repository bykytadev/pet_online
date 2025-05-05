package com.project.pet.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.project.pet.constants.UrlConstant;
import com.project.pet.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.API_V1_PRODUCT)
public class ProductController {

    @GetMapping
    public List<ProductResponse> getProducts() {
        return Arrays.asList(
                new ProductResponse(1, "Thức Ăn Cho Chó", "Đây là thực phẩm cho Chó", BigDecimal.valueOf(150.000), 5,
                        BigDecimal.valueOf(100.000), "Thực phẩm"),
                new ProductResponse(2, "Thức Ăn Cho Mèo", "Đây là thực phẩm cho Mèo", BigDecimal.valueOf(100.150), 15,
                        BigDecimal.valueOf(240.150), "Thực phẩm"),
                new ProductResponse(3, "Xương Giả", "Sản phẩm xương đồ chơi cho Chó", BigDecimal.valueOf(500.250), 20,
                        BigDecimal.valueOf(350.350), "Đồ chơi"));
    }
}
