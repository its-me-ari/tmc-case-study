package com.example.tmc.entities;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private String id;

    @NotEmpty(message = "name is empty")
    @Size(max = 255, message = "name length must not more than 255 characters")
    private String name;

    private Long createdAt;
}
