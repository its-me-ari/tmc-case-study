package com.example.tmccasestudy.ports.output;

import com.example.tmccasestudy.domain.Product;

public interface SaveProductPort {
    void save(Product category);
}
