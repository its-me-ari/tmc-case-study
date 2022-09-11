package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Price implements Serializable {

    private int start;
    private int end;
}
