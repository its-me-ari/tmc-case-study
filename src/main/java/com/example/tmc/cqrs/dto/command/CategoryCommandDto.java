package com.example.tmc.cqrs.dto.command;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCommandDto {

    private String name;
}
