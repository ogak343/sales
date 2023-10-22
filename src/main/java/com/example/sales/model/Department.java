package com.example.sales.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Department extends SoftDelete {
    private Long id;
    private String legalName;
    private String name;
    private String location;
    private String info;
    private Set<User> users;
}
