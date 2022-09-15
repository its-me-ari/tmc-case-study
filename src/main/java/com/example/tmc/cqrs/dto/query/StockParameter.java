package com.example.tmc.cqrs.dto.query;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockParameter {

    private Integer start;
    private Integer end;
}
