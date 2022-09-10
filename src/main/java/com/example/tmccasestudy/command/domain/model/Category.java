package com.example.tmccasestudy.command.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private String id;
    private String name;
    private Long createdAt;

}
