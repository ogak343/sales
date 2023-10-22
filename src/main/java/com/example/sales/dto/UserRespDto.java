package com.example.sales.dto;

import com.example.sales.commons.constants.Role;
import com.example.sales.model.Number;
import lombok.Data;

@Data
public class UserRespDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private boolean active;
    private Number number;
    private Role role;
}
