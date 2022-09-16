package com.example.tmc.cqrs.service;

import com.example.tmc.entities.Category;
import com.example.tmc.transportlayer.event.producer.CategoryEventProducer;
import com.example.tmc.repositories.CategoryRepository;
import com.example.tmc.interactors.impl.CategoryCommandServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryCommandServiceTest {

    private final String CATEGORY_NAME = "Category Name";

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryCommandServiceImpl categoryCommandService;

    @Mock
    private CategoryEventProducer categoryEventProducer;

    private Category category;

    @BeforeEach
    void setUp() {
        category = Category.builder()
                .name(CATEGORY_NAME) // only supply name variable
                .build();
    }

    @Test
    void createCategory() {

        // given
        given(categoryRepository.save(category)).willReturn(category);

        // when
        Category newCategory = categoryCommandService.createCategory(category);

        // then
        assertThat(newCategory).isNotNull();
        assertThat(newCategory.getId()).isNotBlank();
        assertThat(newCategory.getName()).isEqualTo(CATEGORY_NAME);
        assertThat(newCategory.getCreatedAt()).isGreaterThan(0);
    }
}