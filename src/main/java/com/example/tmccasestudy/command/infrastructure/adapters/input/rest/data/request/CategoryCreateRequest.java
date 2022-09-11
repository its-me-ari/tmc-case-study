package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequest {

    private String name;

}