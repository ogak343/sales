package com.example.sales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class DepartmentEntity extends SoftDeleteEntity {
    @Id
    private Long id;
    private String legalName;
    private String name;
    private String location;
    private String info;
    @ManyToMany
    private Set<UserEntity> users;
    @OneToMany
    private Set<NumberEntity> numbers;
}
