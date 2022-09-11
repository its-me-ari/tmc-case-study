package com.example.tmc.application.ports.output;

import com.example.tmc.domain.model.Product;

public interface ProductOutputNoSqlPort {

    Product saveProduct(Product product);
}
