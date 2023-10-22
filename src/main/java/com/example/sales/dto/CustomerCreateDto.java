package com.example.sales.dto;

import com.example.sales.commons.constants.NotificationType;
import lombok.Data;

@Data
public class UserCreateDto {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private NotificationType type;
    private String email;
    private String number;
}
