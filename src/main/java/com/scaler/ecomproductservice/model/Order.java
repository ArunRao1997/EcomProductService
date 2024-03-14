package com.scaler.ecomproductservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_ORDERS")
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> products;
}
