package com.example.tmccasestudy.command.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    private String id;
    private String name;
    private Long createdAt;

}
