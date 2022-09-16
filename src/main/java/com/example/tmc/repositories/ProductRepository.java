package com.example.tmc.repositories;


import com.example.tmc.entities.Product;

public interface ProductRepository {

    Product saveProduct(Product product);

    Product saveDocument(Product product);

}
