package com.example.tmccasestudy.command.application.ports.output;

import com.example.tmccasestudy.command.domain.model.Product;

public interface ProductOutputPort {

    Product saveProduct(Product product);
}
