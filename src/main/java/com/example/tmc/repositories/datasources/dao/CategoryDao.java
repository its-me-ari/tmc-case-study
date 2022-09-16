package com.example.tmc.repositories.datasources.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryDao {
    @Id
    private String id;
    private String name;
    private Long createdAt;
}
