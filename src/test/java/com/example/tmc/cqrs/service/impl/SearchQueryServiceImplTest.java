package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.dto.query.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.repository.ProductElasticRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchQueryServiceImplTest {

    @Mock
    private ProductElasticRepository productElasticRepository;

    @InjectMocks
    private SearchQueryServiceImpl searchQueryService;

    private Pageable pageable;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 10);
    }

    @Test
    void searchWithSkuIn123() {

        // given
        List<String> skuList = Arrays.asList
                (new String[]{
                        "1",
                        "2",
                        "3"
                });
        QueryParameter queryParameter =
                QueryParameter.builder()
                        .sku(skuList)
                        .build();
        when(productElasticRepository.findBySkuIn(skuList, pageable))
                .thenReturn(new PageImpl<>(
                        List.of(
                                ProductDocument.builder().sku("1").build(),
                                ProductDocument.builder().sku("2").build(),
                                ProductDocument.builder().sku("3").build()
                        )
                ));

        // when
        Page<ProductDocument> products = searchQueryService.search(queryParameter, pageable);

        // then
        assertThat(products).isNotEmpty();
    }

    @Test
    void searchWithNameLikeABC() {

        // given
        List<String> nameList = Arrays.asList
                (new String[]{
                        "a",
                        "b",
                        "c"
                });
        QueryParameter queryParameter =
                QueryParameter.builder()
                        .name(nameList)
                        .build();
        when(productElasticRepository.findByNameIn(nameList, pageable))
                .thenReturn(new PageImpl<>(
                        List.of(
                                ProductDocument.builder().name("a").build(),
                                ProductDocument.builder().name("b").build(),
                                ProductDocument.builder().name("c").build()
                        )
                ));

        // when
        Page<ProductDocument> products = searchQueryService.search(queryParameter, pageable);

        // then
        assertThat(products).isNotEmpty();
    }
}