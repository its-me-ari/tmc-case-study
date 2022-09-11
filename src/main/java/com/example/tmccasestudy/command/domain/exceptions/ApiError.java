package com.example.tmccasestudy.command.domain.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;
}
