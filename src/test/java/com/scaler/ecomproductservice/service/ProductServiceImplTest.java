package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.model.Category;
import com.scaler.ecomproductservice.model.Price;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class ProductServiceImplTest {
    @Mock // mock object of the given attribute
    private ProductRepository productRepository;
    @InjectMocks // class to be tested (i.e., where mock object is injected)
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each:");
        MockitoAnnotations.openMocks(this); // creates auto-closeable resources
    }

    @Test
    public void testProductByTitleSuccess() throws ProductNotFoundException {
        /*
         3A
         Arrange
         Act
         Assert
         */

        // Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);
//        mockPrice.setDiscount(0.0);
//        mockPrice.setCurrency("USD");

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "testProductTitle";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);
        when(productRepository.findProductByTitle(testTitle)).thenReturn(mockProduct);

        // Act
        ProductResponseDTO actualResponse = productService.findProductByTitle(testTitle);

        // Assert
        Assertions.assertEquals(actualResponse.getTitle(), mockProduct.getTitle());
        Assertions.assertEquals(actualResponse.getDescription(), mockProduct.getDescription());
        Assertions.assertEquals(actualResponse.getId(), mockProduct.getId());
        Assertions.assertEquals(actualResponse.getPrice(), mockProduct.getPrice().getAmount());

    }

    @Test
    public void testFindProductByTitle_RepoRespondsWithNullObject() throws ProductNotFoundException {
        // Arrange
        String testTitle = "testProductTitle";
        when(productRepository.findProductByTitle(testTitle)).thenReturn(null);
        // Act
       // ProductResponseDTO actualResponse = productService.findProductByTitle(testTitle);
        // Assert
       // Assertions.assertEquals(actualResponse.getTitle(),testTitle);
        Assertions.assertThrows(ProductNotFoundException.class,()-> productService.findProductByTitle(testTitle));

    }

}
