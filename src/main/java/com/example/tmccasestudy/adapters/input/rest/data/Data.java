package com.example.tmccasestudy.adapters.input.rest.data;

import com.example.tmccasestudy.domain.Category;

public class Data {

    private Category category;

    public Data(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
