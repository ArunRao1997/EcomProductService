package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.InvalidTitleException;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.mapper.ProductMapper;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.convertProductsToProductListResponseDTO(products);
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product updateProduct(int id, Product updateProduct) {
        return null;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundException {
        if(title == null || title.isEmpty()){
            throw new InvalidTitleException("title is invalid");
        }
        Product product = productRepository.findProductByTitle(title);
        if(product == null){
            throw new ProductNotFoundException("Product with given title is not available");
        }
        return ProductMapper.convertProductToProductResponseDTO(product);
    }
}
