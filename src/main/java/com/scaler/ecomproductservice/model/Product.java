package com.scaler.ecomproductservice.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
