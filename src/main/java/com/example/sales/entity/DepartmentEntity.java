package com.example.sales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    private Long id;
    private String legalName;
    private String name;
    private String location;
    private String info;
    private 
}
