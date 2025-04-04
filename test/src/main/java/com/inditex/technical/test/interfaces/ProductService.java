package com.inditex.technical.test.interfaces;

import com.inditex.technical.test.model.ProductDto;

import java.util.List;


public interface ProductService {

    List<ProductDto> getSimilarProducts(String productId);
}
