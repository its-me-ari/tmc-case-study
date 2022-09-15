package com.example.tmc.cqrs.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchQueryStockDto {

    private Integer start;
    private Integer end;
}
