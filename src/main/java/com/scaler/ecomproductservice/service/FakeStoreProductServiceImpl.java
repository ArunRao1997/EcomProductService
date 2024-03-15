package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.*;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.service.client.FakeStoreAPIClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.scaler.ecomproductservice.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.ecomproductservice.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.ecomproductservice.utils.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOS = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOS) {
            productListResponseDTO.getProducts().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if (isNull(fakeStoreProductResponseDTO)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

//    @Override
//    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
//        String createProductURL = "https://fakestoreapi.com/products/";
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<ProductResponseDTO> productResponse =
//                restTemplate.postForEntity(createProductURL,productRequestDTO,ProductResponseDTO.class);
//        return productResponse.getBody();
//    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updateProduct) {
        return null;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) {
        return null;
    }
}
