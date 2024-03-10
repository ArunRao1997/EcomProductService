package com.scaler.ecomproductservice.service.client;

import com.scaler.ecomproductservice.dto.FakeStoreProductRequestDTO;
import com.scaler.ecomproductservice.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class FakeStoreAPIClient {

     private String fakeStoreAPIURL;


    private String fakeStoreAPIPathProduct;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(@Value("${fakestore.api.url}") String fakeStoreAPIURL,  @Value("${fakestore.api.path.product}") String fakeStoreAPIPathProduct, RestTemplateBuilder restTemplateBuilder) {
        this.fakeStoreAPIURL = fakeStoreAPIURL;
        this.fakeStoreAPIPathProduct = fakeStoreAPIPathProduct;
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
        String createProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductURLById = fakeStoreAPIURL + fakeStoreAPIPathProduct+ "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductURLById, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(Objects.requireNonNull(productResponseArray.getBody()));
    }

    public void deleteProduct(int id) {
        String deleteProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct+ "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }
}
