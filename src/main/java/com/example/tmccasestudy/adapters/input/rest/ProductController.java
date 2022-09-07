package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.ProductRequest;
import com.example.tmccasestudy.domain.Product;
import com.example.tmccasestudy.ports.input.CreateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private CreateProductService service;

    public ProductController(CreateProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> submitProduct(@RequestBody @Valid ProductRequest product) {
        Product newProduct = service.save(product);
        Map<String, Product> responseMap = new HashMap<>();
        responseMap.put("data", newProduct);
        return ResponseEntity.ok(responseMap);
    }

}
