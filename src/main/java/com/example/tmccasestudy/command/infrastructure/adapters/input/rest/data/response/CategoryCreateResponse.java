package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateResponse {

    private String id;
    private String name;
    private Long createdAt;

}