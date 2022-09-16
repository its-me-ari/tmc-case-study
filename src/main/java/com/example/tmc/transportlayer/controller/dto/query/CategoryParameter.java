package com.example.tmc.transportlayer.controller.dto.query;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryParameter {

    private List<String> id;
    private List<String> name;
}
