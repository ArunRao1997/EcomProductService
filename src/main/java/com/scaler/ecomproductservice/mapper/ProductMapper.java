package com.scaler.ecomproductservice.mapper;

import com.scaler.ecomproductservice.dto.*;
import com.scaler.ecomproductservice.model.Product;

import java.util.List;

public class ProductMapper {

    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());

        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        // productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());

        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> products) {
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for (Product p : products) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setId(p.getId());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setTitle(p.getTitle());
            productResponseDTO.setPrice(p.getPrice().getAmount());
            productResponseDTO.setCategory(p.getCategory().getCategoryName());
            productResponseDTO.setDescription(p.getDescription());
            productListResponseDTO.getProducts().add(productResponseDTO);
        }
        return productListResponseDTO;
    }

    public static ProductResponseDTO convertProductToProductResponseDTO(Product p) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(p.getId());
        productResponseDTO.setImage(p.getImage());
        productResponseDTO.setTitle(p.getTitle());
        productResponseDTO.setPrice(p.getPrice().getAmount());
        productResponseDTO.setCategory(p.getCategory().getCategoryName());
        productResponseDTO.setDescription(p.getDescription());
        return productResponseDTO;
    }
}
