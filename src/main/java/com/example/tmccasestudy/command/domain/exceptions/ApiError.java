package com.example.tmccasestudy.command.domain.exceptions;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private Map<String, String> errors;
}
