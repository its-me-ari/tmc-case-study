package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.event.producer.ProductEventProducer;
import com.example.tmc.cqrs.repository.CategoryRepository;
import com.example.tmc.cqrs.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductCommandServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductCommandServiceImpl productCommandService;

    @Mock
    private ProductEventProducer productEventProducer;

    private Category category;
    private Product product;
    public static final String CATEGORY_ID = "be638577-aaa6-480a-88c2-92987d7ba5a1";

    @BeforeEach
    void setUp() {

        category = Category.builder()
                .id(CATEGORY_ID)
                .name("Category Name")
                .createdAt(1663298807494L)
                .build();

        product = Product.builder()
                .sku("1")
                .name("Product Name")
                .price(1000000)
                .stock(100)
                .category(
                        Category.builder()
                                .id(CATEGORY_ID)
                                .build()
                )
                .build();
    }

    @Test
    void createProduct() {

        // given
        given(categoryRepository.getById(CATEGORY_ID)).willReturn(Optional.ofNullable(category));
        given(productRepository.saveProduct(product)).willReturn(product);

        // when
        Product newProduct = productCommandService.createProduct(product);

        // then
        assertThat(product)
                .usingRecursiveComparison()
                .isEqualTo(newProduct);
    }

    @Test
    @Disabled
    void createDocument() {
    }
}