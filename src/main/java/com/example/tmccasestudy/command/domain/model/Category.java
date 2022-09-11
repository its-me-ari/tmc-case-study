package com.example.tmccasestudy.command.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    private String id;

    @NotEmpty(message = "name is empty")
    @Size(max = 255, message = "name length must not more than 255 characters")
    private String name;
    private Long createdAt;

}
