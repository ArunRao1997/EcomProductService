package com.scaler.ecomproductservice.service.client;

import com.scaler.ecomproductservice.dto.FakeStoreProductRequestDTO;
import com.scaler.ecomproductservice.dto.FakeStoreProductResponseDTO;
import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {
    // @Value("${fakestore.api.url}")
    // private String fakeStoreAPIURL;

    //@Value("${fakestore.api.path.product}")
    //private String fakeStoreAPIPathProduct;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    //    public FakeStoreAPIClient(@Value("${fakestore.api.url}") String fakeStoreAPIURL,  @Value("${fakestore.api.path.product}") String fakeStoreAPIPathProduct, RestTemplateBuilder restTemplateBuilder) {
//        this.fakeStoreAPIURL = fakeStoreAPIURL;
//        this.fakeStoreAPIPathProduct = fakeStoreAPIPathProduct;
//        this.restTemplateBuilder = restTemplateBuilder;
//    }
    //    public FakeStoreAPIClient(@Value("${fakestore.api.url}") String fakeStoreAPIURL, RestTemplateBuilder restTemplateBuilder) {
//        this.fakeStoreAPIURL = fakeStoreAPIURL;
//        this.restTemplateBuilder = restTemplateBuilder;
//    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String productBaseURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(productBaseURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductURLById = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductURLById, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id) {
        String deleteProductURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }
}
