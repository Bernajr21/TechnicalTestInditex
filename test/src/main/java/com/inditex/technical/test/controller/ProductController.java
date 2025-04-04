package com.inditex.technical.test.controller;

import com.inditex.technical.test.model.ProductDto;
import com.inditex.technical.test.service.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "Product similarity API")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;


    @Operation(summary = "Get similar products for a given productId")
    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDto>> getSimilarProducts(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getSimilarProducts(productId));
    }
}
