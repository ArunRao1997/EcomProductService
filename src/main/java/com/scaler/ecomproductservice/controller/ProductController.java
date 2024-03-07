package com.scaler.ecomproductservice.controller;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService; // immutable

    //@Autowired is optional for constructor injection starting Spring 4.x
    public ProductController( @Qualifier("/fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    /*
    Fielld Injection
     */
//    @Autowired
//    @Qualifier("/fakeStoreProductService")
//    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);

       /* ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone15Pro");
        p1.setPrice(1000);
        p1.setCategory("Electronics");
        p1.setDescription("Quite famous and Expensive phone");
        p1.setImage("wwww.google.com/images/iphone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("MacBookAir");
        p2.setPrice(1200);
        p2.setCategory("Electronics");
        p2.setDescription("Quite famous and Expensive Laptop");
        p2.setImage("wwww.google.com/images/macbook");
        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);*/
    }

    @PostMapping("/products")
    public ResponseEntity createProducts(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping ("/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id){
        boolean responseDTO = productService.deleteProduct(id);
        return ResponseEntity.ok(responseDTO);
    }
}
