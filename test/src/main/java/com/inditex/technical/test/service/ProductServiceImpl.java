package com.inditex.technical.test.service;

import com.inditex.technical.test.interfaces.ProductService;
import com.inditex.technical.test.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3001/product/";

    public ProductServiceImpl() {
        this.restTemplate = new RestTemplate();
    }
    public List<ProductDto> getSimilarProducts(String productId) {
        try {

            String[] similarIds = restTemplate.getForObject(BASE_URL + productId + "/similarids", String[].class);

            if (similarIds == null) return List.of();


            return Arrays.stream(similarIds)
                    .map(this::getProductDetail)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (RestClientException ex) {
            System.err.println("Error retrieving similar IDs: " + ex.getMessage());
            return List.of();
        }
    }

    private ProductDto getProductDetail(String productId) {
        try {
            ResponseEntity<ProductDto> response = restTemplate.getForEntity(BASE_URL + productId, ProductDto.class);
            return response.getBody();
        } catch (RestClientException ex) {
            System.err.println("Error retrieving product detail for ID " + productId + ": " + ex.getMessage());
            return null;
        }
    }
}
