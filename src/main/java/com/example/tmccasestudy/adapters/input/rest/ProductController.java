package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.ApiResponse;
import com.example.tmccasestudy.adapters.input.rest.data.ProductRequest;
import com.example.tmccasestudy.domain.Product;
import com.example.tmccasestudy.ports.input.CreateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(newProduct);
        return ResponseEntity.ok(apiResponse);
    }

}
