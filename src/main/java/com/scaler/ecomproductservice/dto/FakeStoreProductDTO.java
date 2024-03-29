package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
