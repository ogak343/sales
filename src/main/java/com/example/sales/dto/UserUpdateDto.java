package com.example.sales.dto;

import com.example.sales.model.Number;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Number number;
}
