package com.example.sales.entity;

import com.example.sales.commons.constants.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends SoftDeleteEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private boolean active;
    private Role role;
    @OneToOne
    private NumberEntity number;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<DepartmentEntity> departments;
}
