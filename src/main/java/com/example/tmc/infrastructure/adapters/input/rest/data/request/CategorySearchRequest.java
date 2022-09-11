package com.example.tmc.infrastructure.adapters.input.rest.data.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class CategorySearchRequest implements Serializable {
    private List<String> id;
    private List<String> name;
}
