package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.ApiResponse;
import com.example.tmccasestudy.adapters.input.rest.data.ProductRequest;
import com.example.tmccasestudy.domain.Product;
import com.example.tmccasestudy.ports.input.CreateProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(newProduct);
        return ResponseEntity.ok(apiResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
