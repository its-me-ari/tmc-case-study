package com.example.tmc.cqrs.dto.query;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchQueryCategoryDto {

    private List<String> id;
    private List<String> name;
}
