package com.example.tmccasestudy.command.application.ports.input;

import com.example.tmccasestudy.command.domain.model.Product;

public interface SearchProductUseCase {

    Product searchProduct(Product product);

}
