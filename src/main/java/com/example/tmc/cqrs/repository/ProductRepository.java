package com.example.tmc.cqrs.repository;


import com.example.tmc.cqrs.entity.Product;

public interface ProductRepository {

    Product saveProduct(Product product);

}
