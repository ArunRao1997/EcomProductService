package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.model.Product;


public interface ProductService {
    ProductListResponseDTO getAllProducts();

    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    boolean deleteProduct(int id);

    Product updateProduct(int id, Product updateProduct);

    ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundException;
}
