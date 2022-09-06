package com.example.tmccasestudy.adapters.input.rest.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoryRequest {

    @NotEmpty(message = "name is empty")
    @Size(max = 255, message = "name length must not more than 255 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
