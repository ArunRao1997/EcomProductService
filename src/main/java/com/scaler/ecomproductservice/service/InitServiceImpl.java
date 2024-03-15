package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.model.Category;
import com.scaler.ecomproductservice.model.Order;
import com.scaler.ecomproductservice.model.Price;
import com.scaler.ecomproductservice.model.Product;
import com.scaler.ecomproductservice.repository.CategoryRepository;
import com.scaler.ecomproductservice.repository.OrderRepository;
import com.scaler.ecomproductservice.repository.PriceRepository;
import com.scaler.ecomproductservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private PriceRepository priceRepository;
    private CategoryRepository categoryRepository;

    public InitServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, PriceRepository priceRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialise() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        Category savedCategory = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setCurrency("USD");
        priceIphone.setAmount(1000);
        priceIphone.setDiscount(0);

        Price priceMacBook = new Price();
        priceMacBook.setCurrency("USD");
        priceMacBook.setAmount(1200);
        priceMacBook.setDiscount(10);

        Price priceWatch = new Price();
        priceWatch.setCurrency("USD");
        priceWatch.setAmount(500);
        priceWatch.setDiscount(5);

        Price pricePlayStation = new Price();
        pricePlayStation.setCurrency("USD");
        pricePlayStation.setAmount(250);
        pricePlayStation.setDiscount(12);

        priceIphone = priceRepository.save(priceIphone);
        priceMacBook = priceRepository.save(priceMacBook);
        priceWatch = priceRepository.save(priceWatch);
        pricePlayStation = priceRepository.save(pricePlayStation);

        Product iPhone = new Product();
        iPhone.setTitle("Iphone 15 Pro");
        iPhone.setDescription("Not the best Iphone ever");
        iPhone.setImage("http://someImageURL");
        iPhone.setPrice(priceIphone);
        iPhone.setCategory(electronics);
        iPhone = productRepository.save(iPhone);

        Product macBook = new Product();
        macBook.setTitle("MacBook Air");
        macBook.setDescription("Best MacBook ever");
        macBook.setImage("http://someMacImageURL");
        macBook.setPrice(priceMacBook);
        macBook.setCategory(electronics);
        macBook = productRepository.save(macBook);

        Product watch = new Product();
        watch.setTitle("Apple Watch 8");
        watch.setDescription("Best Apple watch ever");
        watch.setImage("http://somewatchImageURL");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        watch = productRepository.save(watch);

        Product ps5 = new Product();
        ps5.setTitle("PlayStation5");
        ps5.setDescription("Best Playstation ever");
        ps5.setImage("http://somePlayStationImageURL");
        ps5.setPrice(pricePlayStation);
        ps5.setCategory(electronics);
        ps5 = productRepository.save(ps5);

        Order order = new Order();
        order.setProducts(List.of(iPhone,macBook,watch,ps5));
        orderRepository.save(order);


    }
}
